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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.consumer.movie.entity.User;

@RestController
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalanceCliend;

	/**
	 * 调用用户微服务
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("movies/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback") //hystrix回调方法
	public User getUserById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://springcloud-provider-user/users/" + id, User.class);
	}
	
	/**
	 * 直接使用Ribbon的API
	 * @return
	 */
	@GetMapping("/log-instance")
	public String logUserInstance() {
		ServiceInstance serviceInstance = this.loadBalanceCliend.choose("springcloud-provider-user");//虚拟主机名
		
		//打印当前选择的节点
		logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
		System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return "Service-instance";
	}
	
	/**
	 * hystrix回调方法
	 * @param id
	 * @return
	 */
	public User findByIdFallback(Long id){
		User user = new User();
		user.setId(0L);
		return user;
	}
	
	
}
