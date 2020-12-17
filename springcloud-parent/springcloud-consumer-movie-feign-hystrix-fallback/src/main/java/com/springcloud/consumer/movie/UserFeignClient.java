package com.springcloud.consumer.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
@FeignClient(name="springcloud-provider-user",fallback = HystrixClientFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value="users/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id);//两个坑：1.@GetMapping不支持    2.@PathVariable要设置value
	
		
}

/**
 * 为FeignClien添加回退
 * @author 17542
 *
 */
@Component
class HystrixClientFallback implements UserFeignClient {

	@Override
	public User getUserById(Long id) {
		User user = new User();
		user.setId(0L);
		user.setName("Hello,this is hystrix");
		return user;
	}
   
}
