<<<<<<< HEAD
<<<<<<<< HEAD:hellojpa/src/main/java/jpabook/hellojpa/ManyToMan1/MemberV5.java
package jpabook.hellojpa.ManyToMan1;
========
package jpabook.hellojpa.OneToMany2;
>>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c:hellojpa/src/main/java/jpabook/hellojpa/OneToMany2/MemberV2.java
=======
package jpabook.hellojpa.ManyToMany;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class MemberV5 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

<<<<<<< HEAD
<<<<<<<< HEAD:hellojpa/src/main/java/jpabook/hellojpa/ManyToMan1/MemberV5.java
    @ManyToMany
    @JoinTable(name = "member_product")
    private List<ProductV5> products = new ArrayList<ProductV5>();
========
    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;
>>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c:hellojpa/src/main/java/jpabook/hellojpa/OneToMany2/MemberV2.java
=======
    @ManyToMany
    @JoinTable(name = "member_product")
    private List<ProductV5> products = new ArrayList<ProductV5>();
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
