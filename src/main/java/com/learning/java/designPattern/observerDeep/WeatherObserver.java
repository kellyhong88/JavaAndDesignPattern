package com.learning.java.designPattern.observerDeep;

public class WeatherObserver implements Observer {

	private String observerName;

	// 从目标处获取
	private String weather;

	private String remind;

	// 构造函数/构造器
	public WeatherObserver(String name, String remind) {
		this.observerName = name;
		this.remind = remind;
	}

	public void setObserverName(String name) {
		this.observerName = name;
	}

	@Override
	public String getObserverName() {
		return this.observerName;
	}

	public String getWeather() {
		return weather;
	}

	public String getRemind() {
		return remind;
	}

	public void setRemind(String remind) {
		this.remind = remind;
	}

	@Override
	public void update(Subject subject) {
		this.weather = ((WeatherSubject) subject).getWeather();
		System.out.println(observerName + " get the weather message: " + weather);
		System.out.println(observerName + " will not go " + remind + "\n");
	}
}
