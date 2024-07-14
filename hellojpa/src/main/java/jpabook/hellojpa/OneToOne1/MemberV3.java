<<<<<<< HEAD
package jpabook.hellojpa.OneToOne1;
=======
package jpabook.hellojpa;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberV3 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

<<<<<<< HEAD
    @OneToOne
    @JoinColumn(name = "locker_id")
    private LockerV3 locker;
=======
//    @ManyToOne
//    @JoinColumn(name = "team_id", insertable = false, updatable = false)
//    private TeamV3 team;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

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
}
