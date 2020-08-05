package com.jaswine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jaswine.bean.pojo.RocketMqTransLog;
import org.springframework.stereotype.Repository;

/**
 * @author : Jaswine
 * @date : 2020-07-28 09:54
 **/
@Repository
public interface TransLogMapper extends BaseMapper<RocketMqTransLog> {

	RocketMqTransLog selectByTid(String tid);
}
