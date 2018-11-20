package com.learning.java.designPattern.Intro;

public class QuackSilence implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Silence");
    }
}
