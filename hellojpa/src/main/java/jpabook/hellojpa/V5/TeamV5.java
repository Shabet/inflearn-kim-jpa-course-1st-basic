package jpabook.hellojpa.V5;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamV5 extends BaseEntityV5 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<MemberV5> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberV5> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV5> members) {
        this.members = members;
    }
}
