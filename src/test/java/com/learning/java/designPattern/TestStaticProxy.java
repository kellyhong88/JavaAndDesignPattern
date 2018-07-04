package com.learning.java.designPattern;

import com.learning.java.designPattern.staticProxy.*;
import org.junit.Test;

public class TestStaticProxy {

	@Test
	public void testExtends() {
		System.out.println("\n使用继承方式实现代理：");
		Movable carProxy = new CarProxy1();
		carProxy.move();
	}

	@Test
	public void testInterface() {
		System.out.println("\n使用聚合方式实现代理：");
		Car car = new Car();
		Movable carProxy = new CarProxy2(car);
		carProxy.move();
	}

	@Test
	public void testTimeLog() {
		System.out.println("\nfirst timing, then logging");
		Movable car = new Car();
		Movable carProxy1 = new CarLogProxy(car);
		Movable carProxy2 = new CarTimeProxy(carProxy1);
		carProxy2.move();
	}

	@Test
	public void testLogTime() {
		System.out.println("\nfirst logging, then timing");
		Movable car = new Car();
		Movable carProxy1 = new CarTimeProxy(car);
		Movable carProxy2 = new CarLogProxy(carProxy1);
		carProxy2.move();
	}
}
