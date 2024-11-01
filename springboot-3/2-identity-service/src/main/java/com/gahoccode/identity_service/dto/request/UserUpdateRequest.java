package com.gahoccode.identity_service.dto.request;

import jakarta.validation.constraints.Size;

import java.sql.Date;

public class UserUpdateRequest {
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters.")
    private String password;
    private String firstName;
    private String lastName;
    private Date dob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
