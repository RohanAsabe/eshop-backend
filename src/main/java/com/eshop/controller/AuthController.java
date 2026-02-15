package com.eshop.controller;

import com.eshop.entity.User;
import com.eshop.repository.UserRepository;
import com.eshop.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public String login(@RequestBody User loginUser){

        Optional<User> user = userRepository.findByEmail(loginUser.getEmail());

        if(user.isPresent() && encoder.matches(loginUser.getPassword(), user.get().getPassword())){
            return jwtUtil.generateToken(
                    loginUser.getEmail(),
                    user.get().getRole()
            );
        }

        throw new RuntimeException("Invalid email or password");
    }

}
