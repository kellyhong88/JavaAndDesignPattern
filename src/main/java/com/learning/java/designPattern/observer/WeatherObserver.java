package com.learning.java.designPattern.observer;

public class WeatherObserver implements Observer {

	private String observerName;

	private String weatherMessage;

	private String remindEvent;

	public String getObserverName() {
		return this.observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherMessage() {
		return this.weatherMessage;
	}

	public String getRemindEvent() {
		return this.remindEvent;
	}

	public void setRemindEvent(String remindEvent) {
		this.remindEvent = remindEvent;
	}

	public WeatherObserver(String observerName, String remindEvent) {
		this.observerName = observerName;
		this.remindEvent = remindEvent;
	}

	/**
	 * 拉模型
	 */
	@Override
	public void update(Subject subject) {
		this.weatherMessage = ((WeatherSubject) subject).getWeatherMessage();
		System.out.println(observerName + " get the weather message: ");
		System.out.println(weatherMessage);
		System.out.println(observerName + " will go " + remindEvent + "\n");
	}

	/**
	 * 推模型
	 */
	@Override
	public void update(String content) {
		this.weatherMessage = content;
		System.out.println(observerName + " get the weather message: ");
		System.out.println(weatherMessage);
		System.out.println(observerName + " will go " + remindEvent + "\n");
	}
}
