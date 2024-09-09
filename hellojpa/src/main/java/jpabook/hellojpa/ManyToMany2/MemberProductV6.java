package jpabook.hellojpa.ManyToMany2;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MemberProductV6 {

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
}
