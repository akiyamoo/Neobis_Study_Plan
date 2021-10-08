package com.tasks.api.Model;

import com.tasks.api.Entity.User;

//@Getter
public class UserModel {
    private Integer id;
    private String firstName;
    private String lastName;

    public UserModel(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
