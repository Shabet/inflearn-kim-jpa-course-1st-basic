package jpabook.hellojpa.OneToMany2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

<<<<<<< HEAD
public class JpaMainV2 {
=======
public class JpaMain {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //일대다 양방향

            //회원 저장
<<<<<<< HEAD
            MemberV2 member = new MemberV2();
=======
            Member member = new Member();
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
            member.setUsername("member1");
            em.persist(member);

            //팀 저장
<<<<<<< HEAD
            TeamV2 team = new TeamV2();
=======
            Team team = new Team();
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
            team.setName("TeamA");
            team.getMembers().add(member);
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
