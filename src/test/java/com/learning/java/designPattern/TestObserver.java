package com.learning.java.designPattern;

import com.learning.java.designPattern.observer.*;
import org.junit.Test;

public class TestObserver {

	@Test
	public void testWeather() {
		// 1.创建目标
		WeatherSubject subject = new WeatherSubject();

		// 2.创建观察者
		WeatherObserver observer1 = new WeatherObserver("Kerry", "dating");
		WeatherObserver observer2 = new WeatherObserver("Sherry", "shopping");

		// 3.注册观察者
		subject.attach(observer1);
		subject.attach(observer2);

		// 4.目标发布天气 （观察者/订阅者自动获得更新）
		subject.setWeatherMessage("It's a sunny day!");
	}
}
