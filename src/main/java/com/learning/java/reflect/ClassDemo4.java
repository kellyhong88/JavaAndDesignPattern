package com.learning.java.reflect;

import java.lang.reflect.Method;

public class ClassDemo4 {

    public static void main(String[] args) {

        /**
         * 1.要获取一个成员方法就是要获取类的信息，获取类的信息首先要获取类的类类型/类对象
         * */
        A a = new A();
        Class aClass = a.getClass();

        /**
         * 2.一个方法由方法名称和参数列表来决定
         *
         * getMethod获取的是public的方法，包括父类继承来的
         * getDeclaredMethod获取的是自己声明的方法，不论访问权限，但不包括父类继承来的
         * */
        try {
//            Method method = aClass.getMethod("print", new Class[]{int.class, int.class});
            Method method1 = aClass.getMethod("print");
            Method method2 = aClass.getMethod("print", int.class, int.class);
            Method method3 = aClass.getDeclaredMethod("print", String.class, String.class);

            /**
             * 方法的反射操作是指用method对象来进行方法的调用
             *
             * void方法返回的是null
             * 非void方法返回的是对象（需做强制转换）
             * */
            method1.invoke(a);

//            Object o = method2.invoke(a, new Object[]{10, 20});
            Object o = method2.invoke(a, 10, 20);
            if (o == null)
                System.out.println("void method returns null");

            String s = (String) method3.invoke(a, "leave", "the hell");
            System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class A {
    public void print() {
        System.out.println("Leave the hell!");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    protected String print(String a, String b) {
        System.out.println("getDeclaredMethod()可以获取到protected权限的成员方法");
        return a.toUpperCase() + " " + b.toUpperCase();
    }
}

