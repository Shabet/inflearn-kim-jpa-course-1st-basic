package jpabook.hellojpa.V2;

import jakarta.persistence.*;

@Entity
public class MemberV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY) // 전략 추가
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
