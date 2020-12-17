package com.springcloud.consumer.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcloud.consumer.movie.entity.User;

/**
 * 使用Feign实现声明式REST接口
 * @author 17542
 *
 */
@FeignClient("springcloud-provider-user")
public interface UserFeignClient {
	
	@RequestMapping(value="users/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id);//两个坑：1.@GetMapping不支持    2.@PathVariable要设置value
	
	//Post方法测试
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public User postUser(@RequestBody User user);
		
}
