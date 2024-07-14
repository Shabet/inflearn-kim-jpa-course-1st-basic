package jpabook.hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MemberProduct {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
