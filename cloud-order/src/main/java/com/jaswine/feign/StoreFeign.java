package com.jaswine.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author : Jaswine
 * @date : 2020-08-04 15:22
 **/
@FeignClient(value = "CLOUD-GOODS")
public interface StoreFeign {

	@PutMapping(value = "/goods/store/{gid}")
	void substractGoods(@PathVariable(value = "gid") Long gid);

}
