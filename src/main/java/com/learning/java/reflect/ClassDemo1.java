package com.learning.java.reflect;

/**
 * 在面向对象的世界里，万事万物皆对象
 * 类可以实例化自己的对象们，但类本身也是一个对象
 * 类是java.lang.Class类的实例对象
 */
public class ClassDemo1 {

    public static void main(String[] args) {

        /**
         * foo是Foo的实例对象
         * */
        Foo foo = new Foo();

        /**
         * Foo这个类也是一个实例对象
         * 它是java.lang.Class类的实例对象
         *
         * 所有类都是java.lang.Class类的实例对象
         * 这种类对象有3种表达方式
         * */

        /**
         * 第1种表达方式
         * 实际在告诉我们，任何一个类都有一个静态变量成员class
         * class就是这个类的类对象的引用
         * */
        Class class1 = Foo.class;

        /**
         * 第2种表达方式
         * 已知该类的对象，通过对象的getClass方法
         * 从而获取该对象的类的类对象
         * */
        Class class2 = foo.getClass();

        /**
         * 第3种表达方式
         * 输入类的全名作为参数，
         * 传入Class类的静态方法forName中，
         * 从而来获取该类的类对象
         * */
        Class class3 = null;
        try {
            class3 = Class.forName("com.learning.java.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * class1，class2，class3 表示了Foo类的类类型（class type）
         *
         * 万事万物皆对象，
         * 类也是对象，是java.lang.Class类的实例对象，
         * 这个对象我们称为该类的类类型（class type）
         * */

        /**
         * 一个类只可能是Class类的一个实例对象（单例模式）
         *
         * 不管用哪种表示方式获取的引用，
         * 都指向同一个类对象
         * */
        System.out.println(class1 == class2);
        System.out.println(class2 == class3);
        System.out.println(class1 == class3);

        /**
         * 我们可以通过类的类类型(类对象)来创建该类的实例对象
         *
         * 通过class1，class2，class3任何一种类对象来创建Foo的实例对象
         *
         * 通过类对象的newInstance方法来创建类的一个实例对象
         * 前提是该类具有无参数的构造方法
         *
         * 每次调用newInstance方法，会创建一个新的实例对象
         * */
        try {
            Foo foo1 = (Foo) class1.newInstance();
            Foo foo2 = (Foo) class2.newInstance();
            Foo foo3 = (Foo) class3.newInstance();
            System.out.println(foo1 == foo2);
            System.out.println(foo2 == foo3);
            System.out.println(foo1 == foo3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo {
}