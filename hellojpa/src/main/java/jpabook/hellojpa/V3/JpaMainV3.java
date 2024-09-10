package jpabook.hellojpa.V3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMainV3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 조인 전략
            // SuperType에 @DiscriminatorColumn 추가
            // NOTE. @DiscriminatorValue() 를 이용해서 DTYPE 값을 변경할수 있다.

            MovieV3 movie = new MovieV3();
            movie.setDirector("빅터 플레밍");
            movie.setActor("비비안 리");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();

            MovieV3 findMovie = em.find(MovieV3.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
