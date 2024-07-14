<<<<<<< HEAD
package jpabook.hellojpa.ManyToMany2;
=======
package jpabook.hellojpa.ManyToMany;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
<<<<<<< HEAD
public class MemberV6 {
=======
public class MemberV5 {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

<<<<<<< HEAD
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();
=======
    @ManyToMany
    @JoinTable(name = "member_product")
    private List<Product> products = new ArrayList<Product>();
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
