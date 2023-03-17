package com.haohaoit.demo.task;

import com.haohaoit.demo.common.DemoCommonApplicationContext;
import com.haohaoit.demo.core.DemoCoreApplicationContext;
import com.haohaoit.demo.integration.DemoIntegrationApplicationContext;
import com.haohaoit.demo.repository.DemoRepositoryApplicationContext;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DemoTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTaskApplication.class, args);
    }

}
