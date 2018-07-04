package com.learning.java.designPattern.template;

/**
 * 抽象基类 （为所有子类提供一个算法框架/模板）
 * 
 */
public abstract class Beverage {

	/**
	 * 模板方法封装了所有子类共同遵循的算法框架
	 * 
	 * 模板方法一定要声明为final (好莱坞原则)
	 *
	 * public: 模版方法允许所有类访问
	 *
	 * default: 模版方法允许子类继承或同包内其他类访问
	 *
	 * protected: 模板方法允许子类继承或访问
	 *
	 * private: 模板方法不允许任何类继承或访问
	 *
	 * final: 模板方法不允许子类重写
	 */
	public final void makeBeverage() {

		// 1.将水煮沸
		boilWater();

		// 2.泡制饮料
		brewBeverage();

		// 3.倒入杯中
		pourIntoCup();

		// 4.加入调料
		if (isCustomerWantCondiments()) {
			addCondiment();
		}

	}

	/**
	 * 钩子函数(Hook)
	 * 
	 * 1.父类提供一个默认实现(有return值)或空实现(无return值)
	 * 
	 * 2.子类也可重写/覆盖 (即子类可自行决定是否挂钩以及如何挂钩)
	 */
	protected boolean isCustomerWantCondiments() {
		return true;
	}

	/**
	 * 基本方法(所有子类的通用方法)
	 * 
	 * private: 子类不能继承或直接访问
	 * 
	 * 但是子类可以通过继承父类的模板方法(protected或public)来访问父类的私有属性和私有方法
	 */
	private void boilWater() {
		System.out.println("将水煮沸");
	}

	/**
	 * 抽象方法(子类各自实现)
	 * 
	 * protected: 只有子类能访问(延迟到子类实现)
	 */
	protected abstract void brewBeverage();

	/**
	 * 基本方法(所有子类的通用方法)
	 * 
	 * private: 子类不能继承或直接访问
	 * 
	 * 但是子类可以通过继承父类的模板方法(protected或public)来访问父类的私有属性和私有方法
	 */
	private void pourIntoCup() {
		System.out.println("将饮料倒入杯中");
	}

	/**
	 * 抽象方法(子类各自实现)
	 * 
	 * protected: 只有子类能访问(延迟到子类实现)
	 */
	protected abstract void addCondiment();

}
