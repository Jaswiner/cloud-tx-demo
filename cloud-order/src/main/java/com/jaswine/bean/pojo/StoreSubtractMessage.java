package com.jaswine.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jaswine
 * @date : 2020-07-27 16:26
 **/
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoreSubtractMessage {

	private Long id;

	private Integer num;
}
