package jpabook.hellojpa.V3;

import jakarta.persistence.*;

@Entity
public class MemberV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER) //** 전략 변경
    @JoinColumn(name = "team_id")
    private TeamV3 team;

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

    public TeamV3 getTeam() {
        return team;
    }

    public void setTeam(TeamV3 team) {
        this.team = team;
    }
}
