package com.springcloud.consumer.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.consumer.movie.UserFeignClient;
import com.springcloud.consumer.movie.entity.User;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignClient;
	
	
	/**
	 * 调用声明式Feign接口
	 * @param id
	 * @return
	 */
	@GetMapping("movies/{id}")
	public User getUserById(@PathVariable Long id) {
		return this.userFeignClient.getUserById(id);
	}
	
	@GetMapping("/test")
	public User testPost(User user){
		return this.userFeignClient.postUser(user);
	}
}
