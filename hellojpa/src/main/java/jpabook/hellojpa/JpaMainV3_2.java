package jpabook.hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMainV3_2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //제대로 설정한 경우

            //팀 저장
            TeamV3 team = new TeamV3();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV3 member = new MemberV3();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            //양방향일때 해주는게 좋다.
            team.getMembers().add(member);

            em.flush();
            em.clear();

            TeamV3 findTeam = em.find(TeamV3.class, team.getId()); //1차 캐시
            List<MemberV3> members = findTeam.getMembers();
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
