package jpabook.hellojpa.ManyToOne2;

import jakarta.persistence.*;

@Entity
//@Table(name = "member")
public class MemberV0_1 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamV0_1 team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public TeamV0_1 getTeam() {
        return team;
    }

    public void setTeam(TeamV0_1 team) {
        this.team = team;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
