package com.learning.java.thread;

public class TestFatherAndSon {

    public static void main(String[] args) {
        System.out.println("A story about a Father and a Son");
        Thread father = new FatherThread();
        father.start();
        System.out.println("Story not ends");
        try {
            //join含义：等待father线程执行完毕，主线程才继续执行
            father.join();
        } catch (InterruptedException e) {}
        System.out.println("Story now ends");
    }

}
