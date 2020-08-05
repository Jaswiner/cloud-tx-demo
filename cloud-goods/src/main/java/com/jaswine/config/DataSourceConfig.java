package com.jaswine.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author : Jaswine
 * @date : 2020-08-04 15:31
 **/
@Configuration
@Slf4j
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource(){
		return new DruidDataSource();
	}

	@Primary
	@Bean("dataSource")
	public DataSourceProxy dataSource(){
		return new DataSourceProxy(druidDataSource());
	}
}
