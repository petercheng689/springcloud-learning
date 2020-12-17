package com.springcloud.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;




/**
 *电影微服务- 使用Feign整合Hystrix
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerMovieFeignApplication 
{
	
	
	
    public static void main( String[] args )
    {
    	SpringApplication.run(ConsumerMovieFeignApplication.class,args);
    }
}
