package jpabook.hellojpa.V1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.hellojpa.V2.MovieV2;

public class JpaMainV1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 단일 테이블 전략 (default)
            // NOTE. SuperType에 @DiscriminatorColumn 를 하지 않아도 기본적으로 DTYPE 컬럼이 추가됨.

            MovieV1 movie = new MovieV1();
            movie.setDirector("빅터 플레밍");
            movie.setActor("비비안 리");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();

            MovieV1 findMovie = em.find(MovieV1.class, movie.getId());
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
