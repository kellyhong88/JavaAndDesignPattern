package com.learning.java.designPattern;

import com.learning.java.designPattern.observerDeep.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestObserverDeep {

	@Test
	public void testWeather() {
		// 1.创建目标
		WeatherSubject subject = new WeatherSubject();

		// 2.创建观察者
		WeatherObserver observer1 = new WeatherObserver("Kerry", "dating");
		WeatherObserver observer2 = new WeatherObserver("Sherry", "shopping");
		List<Observer> observers = new ArrayList<Observer>();
		observers.add(observer1);
		observers.add(observer2);

		// 3.注册观察者
		subject.attach(observers);

		// 4.目标更新
		subject.setWeather("Sunny");
		subject.setWeather("Rainy");
		subject.setWeather("Snowy");
	}
}
