package jpabook.hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MemberProductV2_1 {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberV2_1 member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductV2_1 product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
