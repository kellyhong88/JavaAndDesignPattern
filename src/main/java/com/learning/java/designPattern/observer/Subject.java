package com.learning.java.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式（发布/订阅模式） 之目标基类
 * 
 * 观察者模式的本质： 触发联动
 * 
 */
public class Subject {

	// 用于保存注册的观察者对象
	private List<Observer> observers = new ArrayList<Observer>();

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

	// 用于通知注册的观察者们更新信息(拉模型)
	protected void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update(this);
		}
	}

	// 用于通知注册的观察者们更新信息(推模型)
	protected void notifyObservers(String content) {
		for (Observer observer : this.observers) {
			observer.update(content);
		}
	}
}
