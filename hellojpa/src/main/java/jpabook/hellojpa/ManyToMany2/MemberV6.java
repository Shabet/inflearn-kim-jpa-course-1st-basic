package jpabook.hellojpa.ManyToMany2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class MemberV6 {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "member")
    private List<MemberProductV6> memberProducts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "member_product")
    private List<ProductV6> products = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
