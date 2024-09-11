package jpabook.hellojpa.V4;

import jakarta.persistence.*;

@Entity
public class MemberV4 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER) //** 전략 변경
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
}
