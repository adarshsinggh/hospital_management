package com.astrotalk.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrotalk.dao.UserRepository;
import com.astrotalk.helper.PhoneNumberValidator;
import com.astrotalk.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	 
	public Map<String, String> saveSignup(User user){
		Map<String, String> map = new HashMap<>();
		String result = "false";
		  if(!PhoneNumberValidator.isValidPhoneNumber(user.getMobile())) {
			result = "phoneNotValid";
		} else if(user.getPassword().trim().length()<=3){
			result = "passwordNotValid";
		} else if(isMobileExists(user.getMobile())) {
			result = "mobileAlreadyExists";
		} else {
			user.setEnteredDate(new Date());
			User save = userRepository.save(user);
			if(save!=null) {
				result = "true";
			}else {
				result = "false";
			}
		}
		map.put("result", result);
		return map;
	}
	
	public boolean isMobileExists(String mobile) {
		User findByMobile = userRepository.findByMobile(mobile);
		if (findByMobile ==null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	

}
