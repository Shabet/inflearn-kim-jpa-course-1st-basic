<<<<<<< HEAD
package jpabook.hellojpa.ManyToMany2;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MemberProduct {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberV6 member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductV6 product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
=======
package jpabook.hellojpa.ManyToMany2;public class MemberProduct {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
}
