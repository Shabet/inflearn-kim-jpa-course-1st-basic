<<<<<<< HEAD
package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;
=======
package jpabook.jpashop.domain;public class Delivery {
>>>>>>> c11722e781104f8cb59885c7d4566ad0a753a26c
}
