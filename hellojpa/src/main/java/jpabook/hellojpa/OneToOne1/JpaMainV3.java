package jpabook.hellojpa.OneToOne1;

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
            //일대일 단방향

            //락커 저장
            LockerV3 locker = new LockerV3();
            locker.setName("locker1");
            em.persist(locker);

            //회원 저장
            MemberV3 member = new MemberV3();
            member.setUsername("member1");
            member.setLocker(locker);
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
