package com.jaswine.bean.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jaswine
 * @date : 2020-07-27 19:33
 **/
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "rocketmq_trasnaction_log")
public class RocketMqTransLog {

	private String transId;
	private String log;
}
