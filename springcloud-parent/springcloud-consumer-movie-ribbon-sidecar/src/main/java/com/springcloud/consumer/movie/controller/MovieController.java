package com.springcloud.consumer.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalanceCliend;

	/**
	 * 调用Python提供的微服务
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/python/getUser")
	public String pythonUser() {
		return this.restTemplate.getForEntity("http://springcloud-sidecar/getUser", String.class).getBody();
	}

	
}
