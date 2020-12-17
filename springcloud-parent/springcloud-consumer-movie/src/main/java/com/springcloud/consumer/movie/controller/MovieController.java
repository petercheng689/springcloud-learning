package com.springcloud.consumer.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.consumer.movie.entity.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.userServicePath}")
	private String userServicePath;
    
	/**
	 * 调用用户微服务
	 * @param id
	 * @return
	 */
	@GetMapping("movies/{id}")
	public User getUserById(@PathVariable Long id) {
		return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	}
}
