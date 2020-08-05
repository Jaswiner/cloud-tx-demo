package com.jaswine.xa;

import com.jaswine.OrderApplication;
import com.jaswine.bean.pojo.Order;
import com.jaswine.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Jaswine
 * @date : 2020-07-22 09:52
 **/
@SpringBootTest(classes = OrderApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class XaTest {


	@Autowired
	private OrderMapper orderMapper;


	@Test
	public void testAdd(){
		Order order = new Order().toBuilder().id(1)
				.name("order-1")
				.fkUserId(1)
				.fkGoodsId(1)
				.status(0).build();
		orderMapper.insert(order);
	}

	@Test
	public void  testSelect(){
		log.info(orderMapper.selectById(1000).toString());
	}

	@Test
	public void testXA(){

	}
}
