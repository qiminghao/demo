package com.haohaoit.demo.repository;

import com.haohaoit.demo.common.DemoCommonApplicationContext;
import org.apache.ibatis.transaction.Transaction;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@Import({
        DemoCommonApplicationContext.class
})
@EnableTransactionManagement
public class DemoRepositoryApplicationContext {

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sessionFactory")
    public SqlSessionFactoryBean sessionFactory(@Qualifier("dataSource") DataSource dataSource) {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory;
    }

    @Bean("transactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("transactionManager") PlatformTransactionManager manager) {
        return new TransactionTemplate(manager);
    }
}
