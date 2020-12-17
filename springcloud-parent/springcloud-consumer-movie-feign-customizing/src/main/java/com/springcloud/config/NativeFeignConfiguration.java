package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class NativeFeignConfiguration {
	@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();//使用feign自带契约
    }
	
	@Bean
    Logger.Level feignLoggerLevel(){ //日志
		return Logger.Level.FULL;
	}

}
