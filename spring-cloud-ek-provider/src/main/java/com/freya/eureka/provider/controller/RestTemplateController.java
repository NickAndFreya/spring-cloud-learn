package com.freya.eureka.provider.controller;

import com.freya.common.api.model.DeptModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/22 21:55
 */
@Slf4j
@RestController
public class RestTemplateController {
	private List<DeptModel> list = null;

	@PostConstruct
	private void init() {
		list = new ArrayList();
		list.add(DeptModel.builder().id(1).name("财务部").location("杭州").build());
		list.add(DeptModel.builder().id(2).name("行政部").location("杭州").build());
		list.add(DeptModel.builder().id(3).name("人事部").location("杭州").build());
		list.add(DeptModel.builder().id(4).name("研发部").location("杭州").build());
		list.add(DeptModel.builder().id(5).name("总裁办").location("杭州").build());
	}


	@GetMapping("/list")
	public List<DeptModel> list() {
		return list;
	}

	@PostMapping("/save")
	public void save(@RequestBody DeptModel model) {
		list.add(model);
	}


	@DeleteMapping("/delete/{index}")
	public void delete(@PathVariable("index") int index) {
		list.remove(index);
	}

	@PutMapping("/modify/{id}")
	public void modify(@PathVariable("id") int id) {
		Iterator<DeptModel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DeptModel model = iterator.next();
			if (model.getId() == id) {
				model.setName("董事会");
			}
			log.info("DeptModel:【{}】", model);
		}
	}
}
