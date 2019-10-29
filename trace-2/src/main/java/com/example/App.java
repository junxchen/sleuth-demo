package com.example;

import brave.Tracer;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired

    Tracer tracer;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace(String name, HttpServletRequest request) {
        log.info("===<call trace-2>===");

        log.info("===<call trace-2, TraceId={}, SpanId={}>===,SpanName:{}, ParentSpanId:{}, Sampled:{}",
            request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"),
            request.getHeader("X-Span-Name"),
            request.getHeader("X-B3-ParentSpanId"), request.getHeader("X-B3-Sampled"));
        log.info("TraceId:{}", tracer.currentSpan().context().traceIdString());
        return "Trace :"+ name;
    }
}
