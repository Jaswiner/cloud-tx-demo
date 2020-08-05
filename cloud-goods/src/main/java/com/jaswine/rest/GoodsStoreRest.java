package com.jaswine.rest;

import com.jaswine.service.GoodsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Jaswine
 * @date : 2020-08-04 15:23
 **/
@RestController
@RequestMapping(value = "/goods/store")
public class GoodsStoreRest {

	@Resource
	private GoodsService goodsService;


	@PutMapping(value = "/{gid}")
	public void substractGoods(@PathVariable(value = "gid") Long gid){
		this.goodsService.storeSubstract(gid);
	}
}
