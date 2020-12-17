package com.springcloud.consumer.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.consumer.movie.TestFeignClient;
import com.springcloud.consumer.movie.UserFeignClient;
import com.springcloud.consumer.movie.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private TestFeignClient  testFeignClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("movies/{id}")
	public User getUserById(@PathVariable Long id){
		return this.testFeignClient.getUserById(id);
		
	}

	@GetMapping("{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName){
		
		return this.userFeignClient.findServiceInfoFromEurekaByServiceName(serviceName);	
	}
		
	
}
