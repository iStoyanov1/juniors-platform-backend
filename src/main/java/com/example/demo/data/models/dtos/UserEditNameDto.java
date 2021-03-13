package com.example.demo.data.models.dtos;

import javax.validation.constraints.Pattern;

public class UserEditNameDto {

    private String firstName;
    private String lastName;

    public UserEditNameDto() {
    }

    @Pattern(regexp = "([А-Я][а-я]{1,14})", message = "Името трябва да бъде на български, да започва с главна буква и да включва между 2-14 символа. ")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Pattern(regexp = "([А-Я][а-я]{1,20})", message = "Фамилията трябва да бъде на български, да започва с главна буква и да включва между 2-20 символа. ")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
