package com.jaswine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author : Jaswine
 * @date : 2020-07-22 08:24
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.jaswine.mapper")
public class OrderApplication {


	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class,args);
	}
}
