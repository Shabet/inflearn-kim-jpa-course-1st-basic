package jpabook.hellojpa.V3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/*
 * subsection 2. 양방향 연관관계와 연관관계의 주인1 - 기본
 */
public class JpaMainV3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //팀 저장
            TeamV3 team = new TeamV3();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV3 member = new MemberV3();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            //조회
            MemberV3 findMember = em.find(MemberV3.class, member.getId());
            List<MemberV3> members = findMember.getTeam().getMembers(); //변경된 부분

            for (MemberV3 m : members) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
