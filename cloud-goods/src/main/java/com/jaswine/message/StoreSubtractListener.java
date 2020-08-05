package com.jaswine.message;

import com.jaswine.bean.pojo.StoreSubtractMessage;
import com.jaswine.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 减库存操作
 *
 * @author : Jaswine
 * @date : 2020-07-27 16:49
 **/
@Service
@RocketMQMessageListener(consumerGroup = "store",topic = "subtract-store")
@Slf4j
public class StoreSubtractListener implements RocketMQListener<StoreSubtractMessage> {

	@Resource
	private GoodsMapper goodsMapper;

	@Override
	public void onMessage(StoreSubtractMessage message) {
		log.info("减少id为：{}的库存数量:{}",message.getId(),message.getNum());
		this.goodsMapper.substractCount(message.getId(),message.getNum());
	}

}
