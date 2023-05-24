package com.example.demo.domains.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {

    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String displayName(){
        return this.firstName + this.lastName;
    }

    public SignupResponse(int id, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName();
    }
}
