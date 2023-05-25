package com.example.demo.services.serviceImpls;

import com.example.demo.domains.request.SignupRequest;
import com.example.demo.domains.response.SignupResponse;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository ;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public SignupResponse signup(SignupRequest signupRequest) {
        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        return new SignupResponse(result.getId(),result.getEmail(),result.getPassword(),result.getFirstName(),result.getLastName());
    }

    @Override
    public User existByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
