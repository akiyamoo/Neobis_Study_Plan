package com.neobis.api.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "price_list")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer id;

/*    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<Product> product_id;*/

    @Column(name = "price_value")
    private Integer value;

    @Column(name = "create_date")
    private Date date;
}
