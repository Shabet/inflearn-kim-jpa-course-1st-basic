package jpabook.hellojpa;

import jakarta.persistence.*;

public class JpaMainV1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //팀 저장
            TeamV1 team = new TeamV1();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV1 member = new MemberV1();
            member.setUsername("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            //조회
            MemberV1 findMember = em.find(MemberV1.class, member.getId());

            Long findTeamId = findMember.getTeamId();
            TeamV1 findTeam = em.find(TeamV1.class, findTeamId);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
