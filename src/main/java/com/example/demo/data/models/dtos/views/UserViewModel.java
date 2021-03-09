package com.example.demo.data.models.dtos.views;


public class UserViewModel {

    private String username;
    private String firstName;
    private String lastName;
    private FileViewModel file;


    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public FileViewModel getFile() {
        return file;
    }

    public void setFile(FileViewModel file) {
        this.file = file;
    }
}
