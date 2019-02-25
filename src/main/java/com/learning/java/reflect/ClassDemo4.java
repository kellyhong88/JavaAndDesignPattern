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
            Method method1 = aClass.getMethod("print");
            Method method2 = aClass.getMethod("print", int.class, int.class); // 或 ("print", new Class[]{int.class, int.class})
            Method method3 = aClass.getDeclaredMethod("print", String.class, String.class);
            Method method4 = aClass.getDeclaredMethod("print", String.class);

            /**
             * 方法的反射操作是指用method对象来进行方法的调用
             *
             * void方法返回的是null
             * 非void方法返回的是对象（需做强制转换）
             * */
            Object o1 = method1.invoke(a);
            System.out.println("Method1 is void method and it returns: " + o1);

            Object o2 = method2.invoke(a, 10, 20); // 或 (a, new Object[]{10, 20})
            System.out.println("Method2 is void method and it returns: " + o2);

            String s3 = (String) method3.invoke(a, "Never", "give up");
            System.out.println("Method3 is not void method and it returns: " + s3);

            if (method4 != null) {
                /**
                 * 获取私有方法的访问权
                 * 注意：这里只是获取访问权，并不是修改方法的实际权限（即原方法还是private权限）
                 * */
                method4.setAccessible(true);
                String s4 = (String) method4.invoke(a, "Hei Girl! Tomorrow is another day");
                System.out.println("Method4 is not void method and it returns: " + s4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class A {
    public void print() {
        System.out.println("There's always a way!");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    protected String print(String a, String b) {
        System.out.println("getDeclaredMethod()可以获取到protected权限的成员方法");
        return a.toUpperCase() + " " + b.toUpperCase(); //转大写
    }

    private String print(String a) {
        System.out.println("getDeclaredMethod()可以获取到private权限的成员方法");
        return a.toLowerCase(); //转小写
    }
}

