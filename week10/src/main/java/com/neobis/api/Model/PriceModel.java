package com.neobis.api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceModel {

    private Integer id;

    private List<ProductModel> product_id;

    private Integer value;

    private Date date;
}
