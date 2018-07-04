package com.example.java.generics;

public class Box<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.add(new Integer(30));
        stringBox.add(new String("I wanna be strong"));

        System.out.printf("整型值：%d\n", integerBox.get());
        System.out.printf("字符串：%s\n", stringBox.get());
    }
}
