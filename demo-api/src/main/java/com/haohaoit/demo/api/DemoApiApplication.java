package com.haohaoit.demo.api;

import com.haohaoit.demo.core.DemoCoreApplicationContext;
import com.haohaoit.demo.integration.DemoIntegrationApplicationContext;
import com.haohaoit.demo.common.DemoCommonApplicationContext;
import com.haohaoit.demo.repository.DemoRepositoryApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        DemoCommonApplicationContext.class,
        DemoRepositoryApplicationContext.class,
        DemoIntegrationApplicationContext.class,
        DemoCoreApplicationContext.class
})
public class DemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

}
