package com.jaswine.bean.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jaswine
 * @date : 2020-07-22 09:49
 **/
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_order")
public class Order {

	private Integer id;
	private String name;
	private Integer fkUserId;
	private Integer fkGoodsId;
	private Integer status;
}
