package jpabook.hellojpa.OneToOne1;

import jakarta.persistence.*;
import jpabook.hellojpa.OneToOne1.LockerV3;

@Entity
@Table(name = "member")
public class MemberV3 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private LockerV3 locker;

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

    public void setLocker(LockerV3 locker) {
        this.locker = locker;
    }
}
