package jpabook.hellojpa.OneToMany2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
<<<<<<< HEAD
public class TeamV2 {
=======
public class Team {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long Id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
<<<<<<< HEAD
    private List<MemberV2> members = new ArrayList<>();
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

<<<<<<< HEAD
    public List<MemberV2> getMembers() {
        return members;
    }

    public void setMembers(List<MemberV2> members) {
=======
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
        this.members = members;
    }
}
