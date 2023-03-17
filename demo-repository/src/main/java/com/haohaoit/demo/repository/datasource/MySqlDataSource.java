package com.haohaoit.demo.repository.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.*;

import javax.sql.DataSource;

@Configuration
public class MySqlDataSource {

    @Bean("dataSource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
