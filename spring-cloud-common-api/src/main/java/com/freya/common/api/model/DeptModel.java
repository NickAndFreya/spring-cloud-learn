package com.freya.common.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/22 21:47
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptModel {
	private int id;
	private String name;
	@JsonIgnore
	private String location;
}
