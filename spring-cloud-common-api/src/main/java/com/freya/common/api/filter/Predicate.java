package com.freya.common.api.filter;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 16:53
 */
public interface Predicate<T> {
	boolean test(T t);
}
