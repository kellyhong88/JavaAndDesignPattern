package com.learning.java.designPattern.observer;

public class WeatherSubject extends Subject {

	private String weatherMessage;

	public String getWeatherMessage() {
		return weatherMessage;
	}

	public void setWeatherMessage(String weatherMessage) {
		this.weatherMessage = weatherMessage;

		// 通知观察者/订阅者 (拉模型)
		this.notifyObservers();

		// 通知观察者/订阅者 (推模型)
		// this.notifyObservers(this.weatherMessage);
	}

}
