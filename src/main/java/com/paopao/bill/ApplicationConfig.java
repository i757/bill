package com.paopao.bill;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 16:30
 */
@Configuration
public class ApplicationConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource(Environment env){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDataSourceClassName(env.getProperty("spring.datasource.driver-class-name"));
        return dataSource;
    }
}
