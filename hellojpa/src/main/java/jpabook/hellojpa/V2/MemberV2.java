package jpabook.hellojpa.V2;

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

    //변경된 부분
//    @Column(name = "team_id")
//    private Long teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamV2 teamV2;

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
        return teamV2;
    }

    public void setTeam(TeamV2 teamV2) {
        this.teamV2 = teamV2;
    }
}
