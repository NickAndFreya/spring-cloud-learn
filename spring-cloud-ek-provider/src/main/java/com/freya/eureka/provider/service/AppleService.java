package com.freya.eureka.provider.service;

import com.freya.common.api.constant.Constant;
import com.freya.common.api.filter.Filter;
import com.freya.common.api.filter.Predicate;
import com.freya.common.api.model.AppleModel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/21 21:57
 */
@Service
public class AppleService {
	private static List<AppleModel> inventory;

	@PostConstruct
	private void init() {
		inventory = new ArrayList<>();
		inventory.add(AppleModel.builder().colour(Constant.Colour.RED.getColour()).weight(150.00).origin("烟台").build());
		inventory.add(AppleModel.builder().colour(Constant.Colour.YELLOW.getColour()).weight(180.00).origin("陕西").build());
		inventory.add(AppleModel.builder().colour(Constant.Colour.RED.getColour()).weight(160.00).origin("青岛").build());
		inventory.add(AppleModel.builder().colour(Constant.Colour.RED.getColour()).weight(130.00).origin("烟台").build());
		inventory.add(AppleModel.builder().colour(Constant.Colour.RED.getColour()).weight(140.00).origin("烟台").build());
		inventory.add(AppleModel.builder().colour(Constant.Colour.RED.getColour()).weight(190.00).origin("河南").build());
	}

	public List<AppleModel> getAppleBigThan140G() {
		List<AppleModel> result = Filter.filter(inventory, (AppleModel apple) -> apple.getWeight() >= 140);
		return result;
	}
}
