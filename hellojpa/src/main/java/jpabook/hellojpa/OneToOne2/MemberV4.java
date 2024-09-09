package jpabook.hellojpa.OneToOne2;

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

    @OneToOne
    @JoinColumn(name = "locker_id")
    private LockerV4 locker;

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

    public void setLocker(LockerV4 locker) {
        this.locker = locker;
    }

    public LockerV4 getLocker() {
        return locker;
    }
}
