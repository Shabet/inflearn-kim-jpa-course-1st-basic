package jpabook.hellojpa.OneToMany1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamV1 {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long Id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
<<<<<<< HEAD
    private List<MemberV1> members = new ArrayList<>();
=======
    private List<Member> members = new ArrayList<>();
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

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

    public List<MemberV1> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV1> members) {
        this.members = members;
    }
}
