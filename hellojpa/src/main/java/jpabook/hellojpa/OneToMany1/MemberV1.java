package jpabook.hellojpa.OneToMany1;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
<<<<<<< HEAD
public class MemberV1 {
=======
public class Member {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

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
