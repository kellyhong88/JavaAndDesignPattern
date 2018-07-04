package com.learning.java.designPattern.staticProxy;

public class CarProxy1 extends Car {

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("Car start moving at time: " + startTime);

		super.move();

		long endTime = System.currentTimeMillis();
		System.out.println("Car stop moving at time " + endTime);
		System.out.println("Cost time: " + (endTime - startTime) + "ms");
	}

}
