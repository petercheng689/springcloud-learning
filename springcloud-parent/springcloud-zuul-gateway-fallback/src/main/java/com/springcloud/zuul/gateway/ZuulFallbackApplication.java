package com.springcloud.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * Zuul的回退
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulFallbackApplication.class, args);
	}
}
