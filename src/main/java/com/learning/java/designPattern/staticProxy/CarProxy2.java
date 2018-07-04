package com.learning.java.designPattern.staticProxy;

public class CarProxy2 implements Movable {

	public CarProxy2(Car car) {
		super();
		this.car = car;
	}

	private Car car;

	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("Car start moving at time: " + startTime);

		car.move();

		long endTime = System.currentTimeMillis();
		System.out.println("Car stop moving at time " + endTime);
		System.out.println("Cost time: " + (endTime - startTime) + "ms");
	}

	public void say() {
	}

}
