package com.learning.java.designPattern.template;

public class Tea extends Beverage {

	@Override
	protected void brewBeverage() {
		System.out.println("用80度的热水浸泡茶叶5分钟");
	}

	@Override
	protected void addCondiment() {
		System.out.println("添加柠檬\n");
	}

	// 茶子类选择挂钩
	@Override
	protected boolean isCustomerWantCondiments() {
		return false;
	}
}
