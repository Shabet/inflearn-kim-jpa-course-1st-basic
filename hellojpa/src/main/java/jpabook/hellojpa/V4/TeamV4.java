package jpabook.hellojpa.V4;

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

    // 추가
    @OneToMany(mappedBy = "team")
    private List<MemberV4> members = new ArrayList<>();

    // 추가
    public void addMember(MemberV4 member) {
        member.setTeam(this);
        members.add(member);
    }

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


}
