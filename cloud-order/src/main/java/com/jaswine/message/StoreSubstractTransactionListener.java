package com.jaswine.message;

import com.jaswine.bean.pojo.RocketMqTransLog;
import com.jaswine.mapper.TransLogMapper;
import com.jaswine.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;

import javax.annotation.Resource;

/**
 * 实现事务消息
 *
 * @author : Jaswine
 * @date : 2020-07-28 10:35
 **/
@RocketMQTransactionListener(txProducerGroup = "tx-subtract-store")
@Slf4j
public class StoreSubstractTransactionListener implements RocketMQLocalTransactionListener {

	@Resource
	private OrderService orderService;
	@Resource
	private TransLogMapper transLogMapper;


	/**
	 * 执行本地事务
	 * @param message 消息
	 * @param o 参数
	 * @return
	 */
	@Override
	public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
		log.info("收到消息");
		String tid = (String)message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
		Integer oid = Integer.valueOf((String)message.getHeaders().get("oid"));


		try {
			log.info("执行事务");
			this.orderService.updateOrderStatusWithTransLog(oid,tid);
			return RocketMQLocalTransactionState.COMMIT;
		}catch (Exception e){
			e.printStackTrace();
			return RocketMQLocalTransactionState.ROLLBACK;
		}

	}

	/**
	 * 消息回查
	 * @param message 消息
	 * @return
	 */
	@Override
	public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
		log.info("消息回查");

		String tid = (String)message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);

		RocketMqTransLog transLog = this.transLogMapper.selectByTid(tid);

		if (transLog != null){
			return RocketMQLocalTransactionState.COMMIT;
		}

		return RocketMQLocalTransactionState.ROLLBACK;
	}
}
