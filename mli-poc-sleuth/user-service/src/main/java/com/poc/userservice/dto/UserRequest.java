package com.poc.userservice.dto;

public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String contactNo;

    public UserRequest() {}

    public UserRequest(String name, String email, String password, String contactNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
