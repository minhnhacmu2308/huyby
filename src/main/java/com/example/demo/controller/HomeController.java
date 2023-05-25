package com.example.demo.controller;

import com.example.demo.domains.request.SignupRequest;
import com.example.demo.domains.response.SignupResponse;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/api/user")
    public String user() {
        return "Hello, User!";
    }

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest SignupRequest){
        User user = userService.existByEmail((SignupRequest.getEmail()));
        if(!Objects.nonNull(user)){
            return ResponseEntity.badRequest().body("Email is existed!");
        }else{
            SignupResponse signupResponse =  userService.signup(SignupRequest);
            return ResponseEntity.ok(signupResponse);
        }
//        Boolean isExistEmail = userService.existByEmail((SignupRequest.getEmail()));
//        System.out.println(isExistEmail);
//        return ResponseEntity.ok("userRepository.findAll()");
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello, Admin!";
    }

}
