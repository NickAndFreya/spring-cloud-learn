package com.freya.common.api.constant;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 16:47
 */
public interface Constant {
	enum Colour {

		RED("red", "红色"),
		ORANGE("orange", "橙色"),
		YELLOW("yellow", "黄色"),
		GREEN("green", "绿色"),
		DBLUE("dblue", "青色"),
		BLUE("blue", "蓝色"),
		PURPLE("purple", "紫色");
		private String colour;
		private String desc;

		private Colour(String colour, String desc) {
			this.colour = colour;
			this.desc = desc;
		}

		public String getColour() {
			return colour;
		}

		public String getDesc() {
			return desc;
		}
	}
}
