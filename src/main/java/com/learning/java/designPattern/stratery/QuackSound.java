package com.learning.java.designPattern.stratery;

public class QuackSound implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quacking");
    }
}
