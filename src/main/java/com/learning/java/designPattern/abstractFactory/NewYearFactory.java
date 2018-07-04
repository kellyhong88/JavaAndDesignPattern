package com.learning.java.designPattern.abstractFactory;

public class NewYearFactory implements PersonFactory {

	public Boy createBoy() {
		return new NewYearBoy();
	}

	public Girl createGirl() {
		return new NewYearGirl();
	}

}
