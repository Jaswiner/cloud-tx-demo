package com.jaswine.service;

import com.jaswine.bean.pojo.StoreSubtractMessage;
import com.jaswine.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author : Jaswine
 * @date : 2020-07-28 09:43
 **/
@Service
@Slf4j
public class GoodsService {

	@Resource
	private GoodsMapper goodsMapper;


	@Transactional(rollbackFor = Exception.class)
	public void storeSubstract(Long gid){
		log.info("Goods服务-->减少库存");
		goodsMapper.substractCount(gid,3);
	}
}
