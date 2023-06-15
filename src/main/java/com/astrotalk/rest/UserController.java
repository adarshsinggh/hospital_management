package com.astrotalk.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrotalk.dao.UserRepository;
import com.astrotalk.helper.PhoneNumberValidator;
import com.astrotalk.model.Login;
import com.astrotalk.model.User;
import com.astrotalk.service.UserService;

@RestController
@RequestMapping("/rest/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping(path = "/signup")
	public Map<String,String> signup(@RequestBody User user){
		return userService.saveSignup(user);
	} 
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Login login) {
	        User user = userRepository.findByMobile(login.getMobile());
	        
	        if (user != null && user.getPassword().equals(login.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }

}
