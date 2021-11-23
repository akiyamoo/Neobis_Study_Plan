package com.neobis.api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandModel {

    private Integer id;
    private String name;
    private String description;

}
