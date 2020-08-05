package com.jaswine.service;

import com.jaswine.bean.pojo.RocketMqTransLog;
import com.jaswine.bean.pojo.StoreSubtractMessage;
import com.jaswine.feign.StoreFeign;
import com.jaswine.mapper.OrderMapper;
import com.jaswine.mapper.TransLogMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author : Jaswine
 * @date : 2020-07-22 10:37
 **/
@Service
@Slf4j
public class OrderService {



	@Autowired
	private OrderMapper orderMapper;
	@Resource
	private TransLogMapper transLogMapper;

	@Resource
	private RocketMQTemplate rocketMQTemplate;

	@Resource
	private StoreFeign storeFeign;


	@GlobalTransactional(rollbackFor = Exception.class)
	public void  payOrderBySeata(Integer oid){
		// 1.修改订单状态
		log.info("开始修改订单状态");
		orderMapper.updateOrderStatusByOrderId(oid);
		log.info("成功修改订单状态");

		// 2.修改库存
		log.info("开始修改库存");
		storeFeign.substractGoods(1L);
		log.info("成功修改库存");

	}



	public void  payOrderByRocketMq(Integer oid){

		// 2.修改库存
		String transactionId = UUID.randomUUID().toString();
		this.rocketMQTemplate.sendMessageInTransaction("tx-subtract-store",
				"subtract-store",
				MessageBuilder
					.withPayload(
						StoreSubtractMessage.builder()
							.id(1L)
							.num(5)
							.build()
					)
					.setHeader("oid", 1)
					.setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
					.build()
				, null);

	}



	////////事务////////

	@Transactional(rollbackFor = Exception.class)
	public void updateOrderStatus(Integer oid){
		log.info("修改订单状态");
		this.orderMapper.updateOrderStatusByOrderId(oid);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateOrderStatusWithTransLog(Integer oid,String tid){
		log.info("更新订单状态");
		this.updateOrderStatus(oid);

		log.info("记录日志");
		transLogMapper.insert(RocketMqTransLog.builder()
		.transId(tid)
		.log("修改订单状态")
		.build());


	}


}
