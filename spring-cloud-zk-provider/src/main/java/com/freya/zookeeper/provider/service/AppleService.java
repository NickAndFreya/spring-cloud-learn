package com.freya.zookeeper.provider.service;

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
 * @date 2020/3/20 17:03
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

	public List<AppleModel> getAllRedApple() {
		List<AppleModel> result = Filter.filter(inventory, new Predicate<AppleModel>() {
			@Override
			public boolean test(AppleModel appleModel) {
				return appleModel.getColour().equals("red");
			}
		});
		return result;
	}
}
