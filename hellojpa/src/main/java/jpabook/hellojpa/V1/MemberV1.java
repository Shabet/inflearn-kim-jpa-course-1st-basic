package jpabook.hellojpa.V1;

import jakarta.persistence.*;

@Entity
public class MemberV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamV1 team;

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

    public TeamV1 getTeam() {
        return team;
    }

    public void setTeam(TeamV1 team) {
        this.team = team;
    }
}
