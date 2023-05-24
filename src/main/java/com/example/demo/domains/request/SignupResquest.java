package com.example.demo.domains.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResquest {

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
