package com.learning.java.designPattern.staticProxy;

public class CarLogProxy implements Movable {

	public CarLogProxy(Movable m) {
		super();
		this.m = m;
	}

	private Movable m;

	public void move() {
		System.out.println("Car start logging");

		m.move();

		System.out.println("Car stop logging");
	}

	public void say() {
	}
}
