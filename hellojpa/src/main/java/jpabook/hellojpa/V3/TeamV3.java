package jpabook.hellojpa.V3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamV3 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long Id;
    private String name;

    // 추가
    @OneToMany(mappedBy = "team")
    private List<MemberV3> members = new ArrayList<>();

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

    public List<MemberV3> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV3> members) {
        this.members = members;
    }
}
