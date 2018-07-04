package com.learning.java.designPattern.template;

public class Coffee extends Beverage {

	@Override
	protected void brewBeverage() {
		System.out.println("用沸水冲泡咖啡");
	}

	@Override
	protected void addCondiment() {
		System.out.println("添加牛奶\n");
	}

	// 咖啡子类不挂钩
}
