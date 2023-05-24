package com.example.demo.services.serviceImpls;

import com.example.demo.domains.request.SignupResquest;
import com.example.demo.domains.response.SignupResponse;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository ;

    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public SignupResponse signup(SignupResquest signupResquest) {
        User user = new User();
        user.setFirstName(signupResquest.getFirstName());
        user.setLastName(signupResquest.getLastName());
        user.setEmail(signupResquest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(signupResquest.getPassword()));
        User result = userRepository.save(user);
        return new SignupResponse(result.getId(),result.getEmail(),result.getPassword(),result.getFirstName(),result.getLastName());
    }

    @Override
    public User existByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
