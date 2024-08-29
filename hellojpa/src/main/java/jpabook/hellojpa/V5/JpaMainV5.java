package jpabook.hellojpa.V5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/*
 * subsection 3. 양방향 연관관계와 연관관계의 주인2 - 주의점, 정리
 */
public class JpaMainV5 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //제대로 설정한 경우

            //팀 저장
            TeamV5 team = new TeamV5();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV5 member = new MemberV5();
            member.setUsername("member1");
//            member.setTeam(team); //**
//            member.changeTeam(team); //**
            em.persist(member);

            team.addMember(member);

//            //양방향일때 해주는게 좋다.
//            team.getMembers().add(member);

//            em.flush();
//            em.clear();

            TeamV5 findTeam = em.find(TeamV5.class, team.getId()); //1차 캐시
            List<MemberV5> members = findTeam.getMembers();
            System.out.println("=======================");
            for (MemberV5 m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("=======================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
