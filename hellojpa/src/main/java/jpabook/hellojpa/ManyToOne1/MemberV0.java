package jpabook.hellojpa.ManyToOne1;

import jakarta.persistence.*;

@Entity
//@Table(name = "member")
public class MemberV0 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamV0 team;

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

    public void setTeam(TeamV0 team) {
        this.team = team;
    }

    public TeamV0 getTeam() {
        return team;
    }
}
