package com.learning.java.designPattern.abstractFactory;

/**
 * 抽象工厂
 */
public interface PersonFactory {

	public Boy createBoy();

	public Girl createGirl();
}
