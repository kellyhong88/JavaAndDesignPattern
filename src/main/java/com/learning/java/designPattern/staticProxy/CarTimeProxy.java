package com.learning.java.designPattern.staticProxy;

public class CarTimeProxy implements Movable {

	public CarTimeProxy(Movable m) {
		super();
		this.m = m;
	}

	private Movable m;

	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("Car start moving at time: " + startTime);

		m.move();

		long endTime = System.currentTimeMillis();
		System.out.println("Car stop moving at time " + endTime);
		System.out.println("Cost time of moving: " + (endTime - startTime) + "ms");
	}

	public void say() {
	}
}
