package com.example.demo.services;

import com.example.demo.domains.request.SignupRequest;
import com.example.demo.domains.response.SignupResponse;
import com.example.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    SignupResponse signup(SignupRequest signupRequest);
    User existByEmail(String email);
}
