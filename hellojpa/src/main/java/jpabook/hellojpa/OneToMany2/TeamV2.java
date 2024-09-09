package jpabook.hellojpa.OneToMany2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamV2 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long Id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<MemberV2> members = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberV2> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV2> members) {
        this.members = members;
    }
}
