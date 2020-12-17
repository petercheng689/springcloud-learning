package com.springcloud.consumer.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcloud.config.FeignConfiguration;
import com.springcloud.consumer.movie.entity.User;

import feign.Param;
import feign.RequestLine;

/**
 * 使用Feign实现声明式REST接口
 * @author 17542
 *
 */
@FeignClient(name="xxx",url="http://localhost:8077",configuration=FeignConfiguration.class)  //使用Feign的url方式
public interface UserFeignClient {
	
    @RequestMapping(value="eureka/apps/{serviceName}",method=RequestMethod.GET)  
	public String findServiceInfoFromEurekaByServiceName (@PathVariable("serviceName") String id);//
	
		
}
