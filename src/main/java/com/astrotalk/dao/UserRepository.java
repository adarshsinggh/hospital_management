package com.astrotalk.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.astrotalk.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByMobile(String mobile);
	
	
}
