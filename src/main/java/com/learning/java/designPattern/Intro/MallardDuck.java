package com.learning.java.designPattern.Intro;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new QuackSound();
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard duck");
    }
}
