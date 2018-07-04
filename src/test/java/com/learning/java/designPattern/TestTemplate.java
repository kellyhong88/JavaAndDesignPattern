package com.learning.java.designPattern;

import com.learning.java.designPattern.template.*;
import org.junit.Test;

public class TestTemplate {

	@Test
	public void test() {
		/**
		 * 父类引用指向子类对象
		 * 
		 * 父类引用只能指向子类中继承的父类的属性和方法，而不能指向子类中新定义的属性和方法
		 * 
		 * 由于成员方法具有多态性 （by the way, 成员属性不具有多态性）， 若子类中重写(Override)了父类中的方法，
		 * 则父类引用会指向子类中重写的方法 （动态链接）
		 */
		Beverage beverage1 = new Coffee();
		Beverage beverage2 = new Tea();

		/**
		 * 父类引用指向子类对象
		 * 
		 * 模板方法(final)只能被继承，不能被覆盖
		 * 
		 * 父类引用可指向子类Coffee，Tea中继承的父类Beverage的模板方法
		 * 
		 * 由于子类Coffee，Tea中重写了父类Beverage的brewBeverage和addCondiment方法，
		 * 所以父类引用会指向子类中重写的方法而非父类中的原有方法 (动态链接)
		 * 
		 * 同样的，若子类中挂载了父类的钩子函数(Hook)，则父类引用会指向子类中重写的钩子函数
		 * 否则，父类引用会指向父类中的钩子函数，即调用钩子函数的默认实现
		 */
		beverage1.makeBeverage();
		beverage2.makeBeverage();
	}

}
