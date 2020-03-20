package com.freya.common.api.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 16:52
 */
public class Filter {
	public static <T> List<T> filter(List<T> source, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T e : source) {
			if (predicate.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
