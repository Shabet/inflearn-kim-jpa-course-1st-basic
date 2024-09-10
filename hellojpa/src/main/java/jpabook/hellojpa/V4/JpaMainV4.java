package jpabook.hellojpa.V4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMainV4 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 구현 클래스마다 테이블 전략
            // @DiscriminatorColumn 은 적용하여도 의미가 없음.
            // NOTE. SuperType을 추상클래스로 변경

            MovieV4 movie = new MovieV4();
            movie.setDirector("빅터 플레밍");
            movie.setActor("비비안 리");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();

            MovieV4 findMovie = em.find(MovieV4.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            // 아래가 문제가 됨. (union SQL)
//            ItemV4 item = em.find(ItemV4.class, movie.getId());
//            System.out.println("item = " + item);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
