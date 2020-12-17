package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * 自定义Feign配置类
 * @author 17542
 *
 */
@Configuration
public class FeignConfiguration {

	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("peter", "admin432");
    }
	
	
}
