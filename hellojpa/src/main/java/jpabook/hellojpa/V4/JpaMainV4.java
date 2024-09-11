package jpabook.hellojpa.V4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMainV4 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 즉시 로딩

            TeamV4 teamA = new TeamV4();
            teamA.setName("teamA");
            em.persist(teamA);

            TeamV4 teamB = new TeamV4();
            teamB.setName("teamB");
            em.persist(teamB);

            MemberV4 member1 = new MemberV4();
            member1.setUsername("member1");
            member1.setTeam(teamA);
            em.persist(member1);

            MemberV4 member2 = new MemberV4();
            member2.setUsername("member2");
            member2.setTeam(teamB);
            em.persist(member2);

            em.flush();
            em.clear();

            // select 문이 몇개 실행되는지 확인
            List<MemberV4> members = em.createQuery("select m from MemberV4 m", MemberV4.class).getResultList();

            // SQL: select * from member
            // SQL: select * from team where team_id = :team_id

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMember(MemberV4 member) {
        System.out.println("member = " + member.getUsername());
        System.out.println("member = " + member.getClass());
    }

    private static void printMemberAndTeam(MemberV4 member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        TeamV4 team = member.getTeam();
        System.out.println("team = " + team);
    }

    private static void logic(MemberV4 m1, MemberV4 m2) {
        System.out.println("m1.class: " + m1.getClass());
        System.out.println("m2.class: " + m2.getClass());

        System.out.println("m1 == m2: " + (m1 == m2));
        System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 == m2: " + (m1 instanceof MemberV4));
        System.out.println("m1 == m2: " + (m2 instanceof MemberV4));
    }
}
