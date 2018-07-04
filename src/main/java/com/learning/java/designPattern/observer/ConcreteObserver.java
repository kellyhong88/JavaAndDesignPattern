package com.learning.java.designPattern.observer;

public class ConcreteObserver implements Observer {

	private String observerInfo;

	public String getObserverInfo() {
		return observerInfo;
	}

	/**
	 * 获取目标类的信息同步到观察者的信息
	 * 
	 * 拉模型: 目标通知观察者更新， 观察者再回调目标来获取更多信息
	 * 
	 * 拉模型是目标不知道观察者需要什么数据，因此把自身传给观察者，由观察者自行取值
	 */
	@Override
	public void update(Subject subject) {

		/**
		 * 此处为什么要将传入的对象subject强转为ConcreteSubject类型？
		 * 
		 * 因为ConcreteSubject类没有重写其父类Subject的notifyObservers方法
		 * 
		 * 所以在调用ConcreteSubject对象中的notifyObservers方法时，
		 * 其实调用的是其继承的父类Subject定义的notifyObservers方法
		 * 
		 * 注意： 即使在子类继承的父类方法中，this也是永远指向当前子类的对象！
		 * 
		 * 我们看到，在父类Subject的notifyObservers方法中，需要访问父类的私有(private)变量observers
		 * 
		 * 虽然在子类中，是不能直接访问父类的私有变量的
		 * 
		 * 但是，子类是可以通过继承或访问父类的非私有(public或protected)方法来访问父类的私有变量！
		 * 
		 * 实际上，就算不是父子关系，一个类A本来就可以通过另一个类B的公共方法去访问类B中的私有变量！
		 * 
		 * get,set方法就是一个例子。也就是说，get,set方法就是为了让别人可以间接访问或修改私有变量 (因为直接访问或修改是不允许的)
		 * 因此，如果完全不想让别人访问或修改私有变量，则不要定义get,set方法
		 * 
		 * 但是在接着调用observer的update方法时，传入的this依然是指向子类ConcreteSubject对象的引用
		 * 
		 * 所以说此处的方法定义中，传入的参数subject是被定义为父类Subject的引用，其实只是为了适配接口Observer中方法声明
		 * 也就是说，其实此处，是将各个可能传入的子类***Subject的引用 “向上转型” 为父类Subject的引用
		 * 
		 * 然而父类引用只能指向子类中继承的父类的属性和方法，而不能指向子类中新定义的属性或方法！
		 * 
		 * 因此，若想访问子类ConcreteSubject中新定义的属性或方法， 则需将父类引用subject “向下转型”
		 * 为子类ConcreteSubject引用
		 */
		this.observerInfo = ((ConcreteSubject) subject).getSubjectInfo();
	}

	/**
	 * 获取目标类的信息同步到观察者的信息
	 * 
	 * 推模型: 目标更新后主动推送观察者指定信息（推送什么信息则是按需定制）
	 * 
	 * 推模型是假定目标知道观察者需要什么数据
	 */
	@Override
	public void update(String content) {
		this.observerInfo = content;
	}

}
