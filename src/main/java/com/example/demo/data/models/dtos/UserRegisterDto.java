package com.example.demo.data.models.dtos;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;

    public UserRegisterDto() {
    }

    @Pattern(regexp = "([A-Z][a-z]+)", message = "Невалидно име. Името трябва да започва с главна буква и да е между 2-14 символа")
    @Size(min = 2, message = "Невалидно име. Името трябва да започва с главна буква и да е между 2-14 символа")
    @Size(max = 14, message = "Невалидно име. Името трябва да започва с главна буква и да е между 2-14 символа")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Pattern(regexp = "([A-Z][a-z]+)", message = "Невалидно име. Името трябва да започва с главна буква и да е между 2-20 символа")
    @Size(min = 2, message = "Невалидно име. Името трябва да започва с главна буква и да е между 2-20 символа")
    @Size(max = 20, message = "Невалидно име. Името трябва да започва с главна буква и да е между 2-20 символа")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Pattern(regexp = "^([\\w\\.\\-]+)@([\\w\\-]+)(\\D(\\.(\\w){2,3})+)$", message = "Неправилен имейл адрес")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "Паролата трябва да съдържа: \nМинимум 8 символа.\n " +
                    "Поне една малка буква.\n" +
                    "Поне една цифра.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
