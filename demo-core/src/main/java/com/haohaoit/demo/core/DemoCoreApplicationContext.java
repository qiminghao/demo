package com.haohaoit.demo.core;

import com.haohaoit.demo.common.DemoCommonApplicationContext;
import com.haohaoit.demo.repository.DemoRepositoryApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({
        DemoCommonApplicationContext.class,
        DemoRepositoryApplicationContext.class
})
public class DemoCoreApplicationContext {

}
