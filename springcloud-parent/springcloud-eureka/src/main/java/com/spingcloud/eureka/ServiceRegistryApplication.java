package com.spingcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Eureka注册中心 
 *
 */
@EnableEurekaServer    // spring-cloud注册中心服务注解
@SpringBootApplication //spring-boot启动注解
public class ServiceRegistryApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ServiceRegistryApplication.class,args);
    }
    
    /**
     * eureka添加安全认证时,高版本security默认加上了 csrf拦截, 所以需要通过重写方法,
     * 把csrf拦截禁用或者对需要在Eureka Server端注册的Eureka客户端放行
     * @author 17542
     *
     */
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        //禁用csrf拦截
        /*http.csrf().disable().authorizeRequests()  
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();*/
        //对需要在注册中心注册的Eureka客户端放行
        	http.csrf().ignoringAntMatchers("/eureka/**");
        	super.configure(http);
        }
    }

}
