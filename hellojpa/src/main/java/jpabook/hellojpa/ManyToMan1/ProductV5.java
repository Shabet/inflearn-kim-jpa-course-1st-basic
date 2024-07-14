<<<<<<< HEAD
package jpabook.hellojpa.ManyToMan1;
=======
package jpabook.hellojpa.ManyToMany;
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductV5 {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "products")
    private List<MemberV5> members = new ArrayList<MemberV5>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
