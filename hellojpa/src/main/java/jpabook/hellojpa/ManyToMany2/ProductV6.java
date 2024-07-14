package jpabook.hellojpa.ManyToMany2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
<<<<<<< HEAD
public class ProductV6 {
=======
public class Product {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<>();

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
