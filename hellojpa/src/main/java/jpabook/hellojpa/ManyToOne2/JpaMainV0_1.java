package jpabook.hellojpa.ManyToOne2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * subsection 1. 다대일[N:1]
 */
public class JpaMainV0_1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //다대일 양방향

            //팀 저장
            TeamV0_1 team = new TeamV0_1();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            MemberV0_1 member = new MemberV0_1();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            team.getMembers().add(member); // 추가

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
