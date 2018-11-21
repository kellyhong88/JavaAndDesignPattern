package com.learning.java.designPattern.stratery;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public abstract void display();

    /** delegate to FlyBehavior implementation to fly for it */
    public void fly() {
        flyBehavior.fly();
    }

    /** delegate to QuackBehavior implementation to quack for it */
    public void quack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

}
