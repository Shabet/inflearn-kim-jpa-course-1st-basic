package jpabook.hellojpa.OneToMany1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * subsection 2. 일대다[1:N]
 */
public class JpaMainV1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //일대다 단방향

            //회원 저장
            MemberV1 member = new MemberV1();
            member.setUsername("member1");
            em.persist(member);

            //팀 저장
            TeamV1 team = new TeamV1();
            team.setName("TeamA");
            team.getMembers().add(member); // member 테이블에 update 문이 실행됨.
            em.persist(team);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
