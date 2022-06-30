package com.example.demo.config;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import kr.co.openlabs.mtf.client.proxy.DataSourceProxyXA;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
@ComponentScan(basePackages = "kr.co.openlabs.mtf")
//@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
public class DataSourceConfiguration {
    
//    @Value("${spring.datasource.hikari.minimum-idle}")
//    int minimumIdle;
//    
//    @Value("${spring.datasource.hikari.maximum-pool-size}")
//    int poolSize;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        HikariConfig config = new HikariConfig();
//        log.info("poolsize is : " + poolSize);
//        config.setMaximumPoolSize(poolSize);
//        config.setMinimumIdle(minimumIdle);
        config.setUsername(dataSourceProperties.getUsername());
        config.setJdbcUrl(dataSourceProperties.getUrl());
        config.setPassword(dataSourceProperties.getPassword());
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(100);
//        config.setIdleTimeout(100000);
//        config.setMaxLifetime(200000);
        HikariDataSource hikariDs = new HikariDataSource(config);
        log.info("dataSource bean 등록");
        return new DataSourceProxyXA(hikariDs);
    }




    /**
     * Transaction Manager Bean등록
     */
//    @Bean
//    public PlatformTransactionManager txManager(DataSource dataSourceProxy) {
//        log.info("PlatformTransactionManager bean 등록");
//        return new DataSourceTransactionManager(dataSourceProxy);
//    }



}