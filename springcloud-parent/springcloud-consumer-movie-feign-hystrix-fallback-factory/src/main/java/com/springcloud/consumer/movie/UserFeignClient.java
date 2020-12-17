package com.springcloud.consumer.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcloud.consumer.movie.entity.User;

import feign.hystrix.FallbackFactory;

/**
 * 使用Feign实现声明式REST接口
 * @author 17542
 *
 */
@FeignClient(name="springcloud-provider-user",fallbackFactory = HystrixClientFallbackFactory.class)
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
class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient>{
	private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient(){

			@Override
			public User getUserById(Long id) {
				logger.info("fallback; reason was:" ,cause);
				User user = new User();
				user.setId(0L);
				user.setName("Hello,this is hystrix!");
				return user;
			}
			
		};
	}
	
	
	
}
