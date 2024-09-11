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
            // 즉시 로딩

            TeamV3 team = new TeamV3();
            team.setName("teamA");
            em.persist(team);

            MemberV3 member1 = new MemberV3();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            MemberV3 m = em.find(MemberV3.class, member1.getId()); // member 테이블만 SQL 조회 실행

            System.out.println("m = " + m.getTeam().getClass()); // proxy

            System.out.println("=====================================");
            System.out.println("teamName = " + m.getTeam().getName());
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

    private static void printMember(MemberV3 member) {
        System.out.println("member = " + member.getUsername());
        System.out.println("member = " + member.getClass());
    }

    private static void printMemberAndTeam(MemberV3 member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        TeamV3 team = member.getTeam();
        System.out.println("team = " + team);
    }

    private static void logic(MemberV3 m1, MemberV3 m2) {
        System.out.println("m1.class: " + m1.getClass());
        System.out.println("m2.class: " + m2.getClass());

        System.out.println("m1 == m2: " + (m1 == m2));
        System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 == m2: " + (m1 instanceof MemberV3));
        System.out.println("m1 == m2: " + (m2 instanceof MemberV3));
    }
}
