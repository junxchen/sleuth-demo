package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */

@RestController
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace(String name) {
        log.info("===<call trace-2>===");
        return "Trace :"+ name;
    }
}
