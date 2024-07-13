package jpabook.hellojpa;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberV4 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

//    @Column(name = "team_id")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamV4 team;

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

    public TeamV4 getTeam() {
        return team;
    }

    public void setTeam(TeamV4 team) {
        this.team = team;
    }

    public void changeTeam(TeamV4 team) {
        this.team = team;

        team.getMembers().add(this);
    }
}
