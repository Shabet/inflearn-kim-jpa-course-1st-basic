package jpabook.hellojpa;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberV2 {

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
    private TeamV2 team;

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

    public TeamV2 getTeam() {
        return team;
    }

    public void setTeam(TeamV2 team) {
        this.team = team;
    }
}
