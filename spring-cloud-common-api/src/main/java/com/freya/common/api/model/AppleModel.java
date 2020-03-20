package com.freya.common.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 16:45
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppleModel {
	//颜色
	private String colour;
	//重量 单位: 克
	private double weight;
	//产地
	private String origin;
}
