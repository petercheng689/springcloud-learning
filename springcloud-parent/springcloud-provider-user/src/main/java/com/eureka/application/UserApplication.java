package com.eureka.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Service服务提供者(eureka client)
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(UserApplication.class,args);
    }
}
