package jpabook.hellojpa.V2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;

public class JpaMainV2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 지연 로딩

            TeamV2 team = new TeamV2();
            team.setName("teamA");
            em.persist(team);

            MemberV2 member1 = new MemberV2();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            MemberV2 m = em.find(MemberV2.class, member1.getId()); // member 테이블만 SQL 조회 실행

            System.out.println("m = " + m.getTeam().getClass()); // proxy

            System.out.println("=====================================");
            m.getTeam().getName(); // 이 시점에 team 테이블에 대한 SQL 조회 실행
            System.out.println("=====================================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMember(MemberV2 member) {
        System.out.println("member = " + member.getUsername());
        System.out.println("member = " + member.getClass());
    }

    private static void printMemberAndTeam(MemberV2 member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        TeamV2 team = member.getTeam();
        System.out.println("team = " + team);
    }

    private static void logic(MemberV2 m1, MemberV2 m2) {
        System.out.println("m1.class: " + m1.getClass());
        System.out.println("m2.class: " + m2.getClass());

        System.out.println("m1 == m2: " + (m1 == m2));
        System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 == m2: " + (m1 instanceof MemberV2));
        System.out.println("m1 == m2: " + (m2 instanceof MemberV2));
    }
}
