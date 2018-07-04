package com.learning.java.designPattern.observerDeep;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 抽象类中必须要有抽象方法
 * 
 * 2. 抽象类中可以有非抽象方法
 * 
 * 3. 抽象类的子类必须实现抽象父类中的抽象方法
 */
public abstract class Subject {

	protected List<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public void attach(List<Observer> observers) {
		this.observers.addAll(observers);
	}

	public void detach(Observer observer) {
		this.observers.remove(observer);
	}

	public void detach(List<Observer> observers) {
		this.observers.removeAll(observers);
	}

	// 抽象类中的抽象方法 （具体方法延迟到子类中实现）
	protected abstract void notifyObservers();

}
