package jpabook.hellojpa.ManyToOne2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "team")
public class TeamV0_1 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long Id;
    private String name;

    // 추가
    @OneToMany(mappedBy = "team")
    private List<MemberV0_1> members = new ArrayList<>();

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

    public List<MemberV0_1> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV0_1> members) {
        this.members = members;
    }
}
