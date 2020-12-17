package com.springcloud.config.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config Server
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
