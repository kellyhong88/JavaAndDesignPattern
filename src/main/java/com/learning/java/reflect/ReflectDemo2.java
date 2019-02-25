package com.learning.java.reflect;

public class ReflectDemo2 {

    public static void main(String[] args) {

        /**
         * 基本类型（int，double等）不是面向对象
         * 但它们也有类类型
         * */
        Class c1 = int.class;
        Class c2 = double.class;

        /**
         * String，Integer，Double等基本类型的封装是面向对象的
         * 它们自然有类类型
         * */
        Class c3 = String.class;
        Class c4 = Integer.class;
        Class c5 = Double.class;

        /**
         * 一些java关键字也有类类型
         * 如void是作为返回值的一种
         * */
        Class c6 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName() + ", " + c3.getSimpleName());
        System.out.println(c4.getName() + ", " + c4.getSimpleName());
        System.out.println(c5.getName() + ", " + c5.getSimpleName());
        System.out.println(c6.getName());

    }
}
