package com.haohaoit.demo.integration;

import com.haohaoit.demo.common.DemoCommonApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({
        DemoCommonApplicationContext.class
})
public class DemoIntegrationApplicationContext {

}
