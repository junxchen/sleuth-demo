package com.example;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

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

    @RequestMapping(value = "/trace-1", method = RequestMethod.GET)
    public String trace(String name) {
        log.info("===call trace-1===");
        Map map = Maps.newHashMap();
        map.put("name", name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate().getForObject("http://trace2/trace-2?name={name}", String.class, map);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
