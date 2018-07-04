package com.learning.java.designPattern.abstractFactory;

public class ChristmasFactory implements PersonFactory {

	public Boy createBoy() {
		return new ChristmasBoy();
	}

	public Girl createGirl() {
		return new ChristmasGirl();
	}

}
