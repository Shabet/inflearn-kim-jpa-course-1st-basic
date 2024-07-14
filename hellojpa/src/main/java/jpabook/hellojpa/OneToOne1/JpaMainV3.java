<<<<<<< HEAD
package jpabook.hellojpa.OneToOne1;
=======
package jpabook.hellojpa;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMainV3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //일대일 단방향

            //회원 저장
            MemberV3 member = new MemberV3();
            member.setUsername("member1");
            em.persist(member);
<<<<<<< HEAD
=======
//
//            //팀 저장
//            TeamV2 team = new TeamV2();
//            team.setName("TeamA");
//            team.getMembers().add(member);
//            em.persist(team);
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
