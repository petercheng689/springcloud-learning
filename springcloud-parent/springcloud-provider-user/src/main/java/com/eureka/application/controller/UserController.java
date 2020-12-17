package com.eureka.application.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.application.dao.UserDao;
import com.eureka.application.entity.User;



@RestController
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@GetMapping("users/{id}")
	public User getUserById(@PathVariable("id") Long id){
		System.out.println("接受到请求:"+id);
		User user = new User();
        user.setId(id);
        Example<User> userExample = Example.of(user);
        return this.userDao.findOne(userExample).orElse(null); 
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user){
		return user;
	}
	
							
}
