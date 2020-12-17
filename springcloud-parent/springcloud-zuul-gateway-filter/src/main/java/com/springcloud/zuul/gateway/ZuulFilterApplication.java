package com.springcloud.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

import com.springcloud.zuul.filter.PreRequestLogFilter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFilterApplication {
	
	@Bean
	public PreRequestLogFilter preRequestLogFilter(){
		return new PreRequestLogFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulFilterApplication.class, args);
	}
}
