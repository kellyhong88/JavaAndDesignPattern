package com.learning.java.designPattern.stratery;

public class QuackSilence implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Silence");
    }
}
