package com.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.User;
import com.eshop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	 public User saveUser(User user) {

		    if(userRepository.findByEmail(user.getEmail()).isPresent()){
		        throw new RuntimeException("Email already registered");
		    }

		    user.setPassword(encoder.encode(user.getPassword()));

		    // default role
		    user.setRole("USER");

		    return userRepository.save(user);
		}

}
