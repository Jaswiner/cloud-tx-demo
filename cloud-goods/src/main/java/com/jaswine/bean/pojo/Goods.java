package com.jaswine.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jaswine
 * @date : 2020-07-27 16:56
 **/
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

	private Long id;

	private String name;

	private Integer count;
}
