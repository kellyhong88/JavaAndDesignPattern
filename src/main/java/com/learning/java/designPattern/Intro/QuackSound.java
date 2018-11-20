package com.learning.java.designPattern.Intro;

public class QuackSound implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quacking");
    }
}
