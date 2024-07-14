package jpabook.hellojpa.OneToOne1;

import jakarta.persistence.*;

@Entity
<<<<<<< HEAD
public class LockerV3 {
=======
public class Locker {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private MemberV3 member;
}
