package com.springcloud.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;





/**
 * 带ribbon的电影微服务启动类
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMovieRibbonApplication 
{
	/**
	 * Netflix中默认配置Ribbon的方式
	 * @return
	 */
	@Bean
	@LoadBalanced  //ribbon实现客户端负载均衡(使用默认的负载均衡路由算法)
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(ConsumerMovieRibbonApplication.class,args);
    }
}
