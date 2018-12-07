package com.learning.java.multiThread;

public class ActingTask {

    public static void main(String[] args) {
        System.out.println("Show begins");
        Thread actor = new Actor("Jack");
        Thread actress = new Thread(new Actress(), "Rose");
        actor.start();
        actress.start();
        System.out.println("Please enjoy");
    }

}
