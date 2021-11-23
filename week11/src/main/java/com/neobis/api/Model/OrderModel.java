package com.neobis.api.Model;

import com.neobis.api.Entity.Product;
import com.neobis.api.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    private Integer id;

    private int sum;

    private Date date;

    private User user;

    private List<Product> products;
}
