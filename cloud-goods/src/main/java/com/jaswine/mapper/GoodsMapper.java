package com.jaswine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jaswine.bean.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : Jaswine
 * @date : 2020-07-27 16:57
 **/
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

	boolean substractCount(@Param("id") Long id,
	                       @Param("num") Integer num);
}
