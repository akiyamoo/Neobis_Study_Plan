package com.neobis.api.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brands")
@Data
public class Brand {

    @Id
    @Column(name = "brand_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "brand_name", nullable = false)
    private String name;

    @Column(name = "brand_description")
    private String description;

}
