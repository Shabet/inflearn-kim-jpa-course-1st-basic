package jpabook.hellojpa.V1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;

public class JpaMainV1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Proxy

            MemberV1 member = new MemberV1();
            member.setUsername("hello");
            em.persist(member);

            em.flush();
            em.clear();

            MemberV1 m1 = em.find(MemberV1.class, member.getId());
            printMember(m1);
            printMemberAndTeam(m1);

//            em.flush();
//            em.clear();

            // select문이 실행되는 시점을 유념히 볼것!
            MemberV1 findMember = em.getReference(MemberV1.class, member.getId());
            logic(m1, findMember);

            System.out.println("before findMember = " + findMember.getClass()); // proxy class
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.username = " + findMember.getUsername()); // 이 시점에 select sql문이 실행
            System.out.println("findMember.username = " + findMember.getUsername()); // select sql문이 실행안됨
            System.out.println("after  findMember = " + findMember.getClass());

            em.flush();
            em.clear();

            //
            MemberV1 refMbr = em.getReference(MemberV1.class, member.getId());
            System.out.println("refMember = " + refMbr.getClass()); // Proxy

            MemberV1 findMbr = em.find(MemberV1.class, member.getId());
            System.out.println("findMbr = " + findMbr.getClass()); // Member <- Proxy class

            System.out.println("refMbr == findMbr: " + (refMbr == findMbr));

            Hibernate.initialize(refMbr); // 강제초기화

//            em.detach(member);
            em.clear();
            System.out.println("member = " + member.getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMember(MemberV1 member) {
        System.out.println("member = " + member.getUsername());
        System.out.println("member = " + member.getClass());
    }

    private static void printMemberAndTeam(MemberV1 member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        TeamV1 team = member.getTeam();
        System.out.println("team = " + team);
    }

    private static void logic(MemberV1 m1, MemberV1 m2) {
        System.out.println("m1.class: " + m1.getClass());
        System.out.println("m2.class: " + m2.getClass());

        System.out.println("m1 == m2: " + (m1 == m2));
        System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 == m2: " + (m1 instanceof MemberV1));
        System.out.println("m1 == m2: " + (m2 instanceof MemberV1));
    }
}
