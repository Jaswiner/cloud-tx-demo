package com.jaswine.rest;

import com.jaswine.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Jaswine
 * @date : 2020-07-28 10:53
 **/
@RestController
@RequestMapping(value = "/order")
public class OrderRest {


	@Resource
	private OrderService orderService;

	@PutMapping(value = "/mq/{oid}")
	public void updateOrderStatus(@PathVariable Integer oid){
		this.orderService.payOrderByRocketMq(oid);
	}

	@PutMapping(value = "/seata/{oid}")
	public void payOrder(@PathVariable Integer oid){
		this.orderService.payOrderBySeata(oid);
	}

}
