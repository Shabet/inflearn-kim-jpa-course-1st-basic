package jpabook.hellojpa.OneToOne2;

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
            //일대일 양방향

            //락커 저장
            LockerV4 locker = new LockerV4();
            locker.setName("locker1");
            em.persist(locker);

            //회원 저장
            MemberV4 member = new MemberV4();
            member.setUsername("member1");
            member.setLocker(locker);
            em.persist(member);

            locker.setMember(member);

            System.out.println("##############################################");
//            System.out.println(locker.getMember().getLocker().getName());
            System.out.println(locker.getMember());
            System.out.println("##############################################");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
