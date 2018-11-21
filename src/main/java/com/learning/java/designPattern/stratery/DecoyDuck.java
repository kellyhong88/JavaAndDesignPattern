package com.learning.java.designPattern.stratery;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new QuackSilence();
    }

    @Override
    public void display() {
        System.out.println("I'm a decoy duck");
    }
}
