package com.learning.java.designPattern.observer;

public class ConcreteSubject extends Subject {

	// 目标对象的信息
	private String subjectInfo;

	public String getSubjectInfo() {
		return subjectInfo;
	}

	public void setSubjectInfo(String subjectInfo) {
		this.subjectInfo = subjectInfo;

		// 通知注册的观察者们更新信息(拉模型)
		this.notifyObservers();

		// 通知注册的观察者们更新信息(推模型)
		this.notifyObservers(this.subjectInfo);
	}

}
