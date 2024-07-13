package jpabook.hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamV4 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long Id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<MemberV4> members = new ArrayList<>();

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

    public List<MemberV4> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV4> members) {
        this.members = members;
    }

    public void addMember(MemberV4 member) {
        member.setTeam(this);
        members.add(member);
    }
}
