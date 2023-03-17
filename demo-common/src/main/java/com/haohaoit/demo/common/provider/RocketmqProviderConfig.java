package com.haohaoit.demo.common.provider;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketmqProviderConfig {

//
//    @Bean
//    public RocketMQTemplate rocketMQTemplate() {
//        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
//        DefaultMQProducer producer = new DefaultMQProducer();
////        producer
////        rocketMQTemplate.setProducer();
//        return rocketMQTemplate;
//    }
}
