package com.learning.java.designPattern.staticProxy;

import java.util.Random;

public class Car implements Movable {

	public void move() {
		try {
			System.out.println("Car's moving...");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void say() {
	}

}
