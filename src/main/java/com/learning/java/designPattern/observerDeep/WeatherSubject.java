package com.learning.java.designPattern.observerDeep;

public class WeatherSubject extends Subject {

	// "Sunny" or "Rainy" or "Snowy"
	private String weather;

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
		this.notifyObservers();
	}

	@Override
	protected void notifyObservers() {
		for (Observer observer : this.observers) {
			// Sunny: 不通知任何观察者

			// Rainy: 通知所有观察者
			if ("Rainy".equalsIgnoreCase(this.weather))
				observer.update(this);

			// Snowy: 只通知某些观察者
			if ("Snowy".equalsIgnoreCase(this.weather))
				if ("Sherry".equalsIgnoreCase(observer.getObserverName()))
					observer.update(this);
		}
	}

}
