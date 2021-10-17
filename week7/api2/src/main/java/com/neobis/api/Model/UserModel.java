package com.neobis.api.Model;

import lombok.Getter;

@Getter
public class UserModel {

    private Integer id;
    private String firstName;
    private String lastName;

    public UserModel(){}

    public UserModel(Integer id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
