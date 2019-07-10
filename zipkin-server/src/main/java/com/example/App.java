package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Hello world!
 *
 */

@EnableZipkinServer
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
