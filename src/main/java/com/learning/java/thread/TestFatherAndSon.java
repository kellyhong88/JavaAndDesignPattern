package com.learning.java.thread;

public class TestFatherAndSon {

    public static void main(String[] args) {
        System.out.println("A story about a Father and a Son");
        Thread father = new FatherThread();
        father.start();
        System.out.println("Story not ends");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {}
        System.out.println("Story now ends");
    }

}
