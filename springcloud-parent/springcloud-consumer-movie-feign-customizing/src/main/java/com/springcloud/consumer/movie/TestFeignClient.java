package com.springcloud.consumer.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.config.NativeFeignConfiguration;
import com.springcloud.consumer.movie.entity.User;

import feign.Param;
import feign.RequestLine;


@FeignClient(name="springcloud-provider-user",configuration=NativeFeignConfiguration.class)
public interface TestFeignClient {
	@RequestLine("GET users/{id}") //Feign原生注解
	public User getUserById(@Param("id") Long id);
}
