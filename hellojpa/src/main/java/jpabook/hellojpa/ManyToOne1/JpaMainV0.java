package jpabook.hellojpa.ManyToOne1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * subsection 1. 다대일[N:1]
 */
public class JpaMainV0 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //다대일 단방향

            //팀 저장
            TeamV0 team = new TeamV0();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV0 member = new MemberV0();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            //조회
            MemberV0 findMember = em.find(MemberV0.class, member.getId());
            TeamV0 findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            //수정
//            TeamV0 newTeam = em.find(TeamV0.class, 100L);
//            findMember.setTeam(newTeam);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
