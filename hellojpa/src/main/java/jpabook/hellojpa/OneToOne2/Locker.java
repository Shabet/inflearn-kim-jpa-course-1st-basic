<<<<<<< HEAD
package jpabook.hellojpa.OneToOne2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
=======
package jpabook.hellojpa.OneToOne1;

import jakarta.persistence.*;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
<<<<<<< HEAD
    private MemberV4 member;
=======
    private MemberV3 member;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
}
