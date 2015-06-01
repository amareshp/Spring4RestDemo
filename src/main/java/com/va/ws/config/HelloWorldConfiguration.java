package com.va.ws.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.va.ws.camel.CamelUtil;
import com.va.ws.hello.HelloController;

@Configuration
@EnableWebMvc
// comma separated values
@ComponentScan(basePackages = { "com.va.ws" })
public class HelloWorldConfiguration {
    private final static Logger LOGGER = Logger.getLogger(HelloController.class.getName());
    
    @Bean(initMethod = "init", destroyMethod = "cleanup" )
    public CamelUtil foo() {
       return new CamelUtil();
    }
    
}