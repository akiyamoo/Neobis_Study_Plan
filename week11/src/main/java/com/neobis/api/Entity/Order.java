package com.neobis.api.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_sum")
    private int sum;

    @Column(name = "order_date")
    private Date date;

/*    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;*/

/*    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<Product> products;*/

}
