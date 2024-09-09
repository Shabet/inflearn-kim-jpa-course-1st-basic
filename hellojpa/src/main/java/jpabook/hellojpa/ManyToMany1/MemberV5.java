package jpabook.hellojpa.ManyToMany1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class MemberV5 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToMany
    @JoinTable(name = "member_product")
    private List<ProductV5> products = new ArrayList<ProductV5>();

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private TeamV5 team;

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
