package com.learning.java.designPattern;

import com.learning.java.designPattern.factory.*;
import org.junit.Test;

public class TestFactory {

	@Test
	public void test1() {

		/**
		 * 通过工厂模式，使得实现和客户端分离
		 */

		HairFactory hairFactory = new HairFactory();
		Hair hair1 = hairFactory.createHair("left");
		hair1.draw();
		Hair hair2 = hairFactory.createHair("right");
		hair2.draw();
		Hair hair3 = hairFactory.createHair("");
		if (hair3 == null)
			System.out.println("没有发型对象被创建");
	}

	@Test
	public void test2() {
		HairFactory hairFactory = new HairFactory();
		Hair hair1 = hairFactory.createHairByClass("com.learning.java.designPattern.factory.LeftHair");
		hair1.draw();
		Hair hair2 = hairFactory.createHairByClass("com.learning.java.designPattern.factory.RightHair");
		hair2.draw();
		Hair hair3 = hairFactory.createHairByClass("com.learning.java.designPattern.factory.SadHair");
		if (hair3 == null)
			System.out.println("没有发型对象被创建");
	}

	@Test
	public void test3() {
		HairFactory hairFactory = new HairFactory();
		Hair hair1 = hairFactory.createHairByProperty("left");
		hair1.draw();
		Hair hair2 = hairFactory.createHairByProperty("right");
		hair2.draw();
		Hair hair3 = hairFactory.createHairByProperty("sad");
		if (hair3 == null)
			System.out.println("没有发型对象被创建");
	}
}
