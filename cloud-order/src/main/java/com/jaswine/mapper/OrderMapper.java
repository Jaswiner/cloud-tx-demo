package com.jaswine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jaswine.bean.pojo.Order;
import org.springframework.stereotype.Repository;

/**
 * @author : Jaswine
 * @date : 2020-07-22 09:51
 **/
@Repository
public interface OrderMapper extends BaseMapper<Order> {


	void updateOrderStatusByOrderId(Integer id);
}
