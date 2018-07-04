package com.learning.java.multiThread;

public class ActingTask {

    public static void main(String[] args) {
        Thread actor = new Actor("Jack");
        Thread actress = new Thread(new Actress(), "Rose");
        actor.start();
        actress.start();
    }

}
