package com.learning.java.designPattern.observer;

/**
 * 观察者模式（发布/订阅模式）之观察者接口
 * 
 * 观察者模式的本质： 触发联动
 */
public interface Observer {

	/**
	 * 拉模型
	 * 
	 * 目标通知观察者更新， 观察者再回调目标来获取更多信息
	 * 
	 * 拉模型是目标不知道观察者需要什么数据，因此把自身传给观察者，由观察者自行取值
	 */
	void update(Subject subject);

	/**
	 * 推模型
	 * 
	 * 目标更新后主动推送观察者指定信息（推送什么信息则是按需定制）
	 * 
	 * 推模型是假定目标知道观察者需要什么数据
	 */
	void update(String content);
}
