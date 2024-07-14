<<<<<<< HEAD
package jpabook.hellojpa.ManyToMany2;
=======
package jpabook.hellojpa.ManyToMany;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
<<<<<<< HEAD

public class JpaMainV6 {
=======
import jpabook.hellojpa.OneToOne2.MemberV4;

public class JpaMainV5 {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //다대다

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
