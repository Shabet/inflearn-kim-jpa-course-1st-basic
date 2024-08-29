package jpabook.hellojpa.V2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * subsection 1. 단방향 연관관계
 */
public class JpaMainV2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //팀 저장
            TeamV2 team = new TeamV2();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV2 member = new MemberV2();
            member.setUsername("member1");
            member.setTeam(team); //변경된 부분
            em.persist(member);

            em.flush(); //조회 테스트를 위해서 추가
            em.clear(); //조회 테스트를 위해서 추가

            //조회
            MemberV2 findMember = em.find(MemberV2.class, member.getId());
            TeamV2 findTeam = findMember.getTeam(); //변경된 부분
            System.out.println("findTeam.name = " + findTeam.getName());

            //수정
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setId(newTeam.getId());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
