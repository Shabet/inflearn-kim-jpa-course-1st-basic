package jpabook.hellojpa.V3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * subsection 3. 양방향 연관관계와 연관관계의 주인2 - 주의점, 정리
 */
public class JpaMainV3_1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //잘못 설정한 경우

            //회원 저장
            MemberV3 member = new MemberV3();
            member.setUsername("member1");
            em.persist(member);

            //팀 저장
            TeamV3 team = new TeamV3();
            team.setName("TeamA");
            team.getMembers().add(member); // bug
            em.persist(team);

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
