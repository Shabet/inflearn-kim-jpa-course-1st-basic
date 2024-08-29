package jpabook.hellojpa.V4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/*
 * subsection 3. 양방향 연관관계와 연관관계의 주인2 - 주의점, 정리
 */
public class JpaMainV4 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //제대로 설정한 경우

            //팀 저장
            TeamV4 team = new TeamV4();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV4 member = new MemberV4();
            member.setUsername("member1");
//            member.setTeam(team); // 정상
//            member.changeTeam(team); //** 둘중에 하나만 사용!
            em.persist(member);

            team.addMember(member); //**

            //양방향일때 해주는게 좋다.
//            team.getMembers().add(member); //

            em.flush();
            em.clear();

            TeamV4 findTeam = em.find(TeamV4.class, team.getId()); // 1차 캐시(em.flush & em.clear 안한 경우)
            List<MemberV4> members = findTeam.getMembers();

            System.out.println("===================");
            for (MemberV4 m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
