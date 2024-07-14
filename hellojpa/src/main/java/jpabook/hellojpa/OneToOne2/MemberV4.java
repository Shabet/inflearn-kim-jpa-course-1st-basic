<<<<<<< HEAD
package jpabook.hellojpa.OneToOne2;
=======
package jpabook.hellojpa.OneToOne1;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.*;

@Entity
@Table(name = "member")
<<<<<<< HEAD
public class MemberV4 {
=======
public class MemberV3 {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

<<<<<<< HEAD
=======
//    @ManyToOne
//    @JoinColumn(name = "team_id", insertable = false, updatable = false)
//    private TeamV3 team;

>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

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
