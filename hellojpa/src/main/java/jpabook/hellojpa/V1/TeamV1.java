package jpabook.hellojpa.V1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamV1 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<MemberV1> members = new ArrayList<>();

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

    public List<MemberV1> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV1> members) {
        this.members = members;
    }
}
