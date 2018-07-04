package com.learning.java.designPattern.factory;

import java.util.Map;

/**
 * 发型工厂
 */
public class HairFactory {

	/**
	 * 根据约定的key来创建对象
	 */
	public Hair createHair(String key) {
		if ("left".equals(key))
			return new LeftHair();
		else if ("right".equals(key))
			return new RightHair();
		else
			return null;
	}

	/**
	 * 根据类的名称来创建对象
	 *
	 * 类名需为包含路径的全名
	 * 
	 * 利用java反射机制
	 */
	public Hair createHairByClass(String className) {
		try {
			Hair hair = (Hair) Class.forName(className).newInstance();
			return hair;
		} catch (Exception e) {
		}
		return null;
	}

	public Hair createHairByProperty(String key) {
		String className;
		try {
			Map<String, String> map = new PropertiesReader().getProperties();
			className = map.get(key);
			if (className != null) {
				Hair hair = (Hair) Class.forName(className).newInstance();
				return hair;
			} else {
				return null;
			}
		} catch (Exception e) {
		}
		return null;
	}
}
