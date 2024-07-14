package jpabook.hellojpa.OneToMany1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

<<<<<<< HEAD
public class JpaMainV1 {
=======
public class JpaMain {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

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
<<<<<<< HEAD
            TeamV1 team = new TeamV1();
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
