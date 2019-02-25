package com.learning.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 一般情况下，我们无法访问或操作一个类的私有变量或私有方法
 * 但是反射却可以做到！
 * 通过反射，我们可以访问类对象的私有变量或私有方法，甚至修改私有变量
 */
public class ReflectDemo6 {

    public static void main(String[] args) {
        Hope hope = new Hope();
        Class hClass = hope.getClass();

        try {
            /**
             * 通过 Method 的 getDeclaredMethod() 获取私有方法
             * */
            Method method = hClass.getDeclaredMethod("privateMethod", String.class, int.class);
            if (method != null) {
                /**
                 * 获取私有方法的访问权
                 * */
                method.setAccessible(true);
                method.invoke(hope, "Java Reflect ", 666);
            }

            /**
             * 通过 Field 的 getDeclaredField() 获取私有变量
             * */
            Field field = hClass.getDeclaredField("privateVariable");
            System.out.println("Before modification: privateVariable = " + hope.getMsg());
            if (field != null) {
                /**
                 * 获取私有变量的访问权
                 * */
                field.setAccessible(true);
                System.out.println("By reflection we can get the original value of this Field: " + field.get(hope));
                field.set(hope, "Modified");
                System.out.println("By reflection we can set a new value for this Field: " + field.get(hope));
            }
            System.out.println("After modification: privateVariable = " + hope.getMsg());

        } catch (Exception e) {
        }
    }
}

class Hope {
    private String privateVariable = "Original";

    private void privateMethod(String head, int tail) {
        System.out.println(head + tail);
    }

    public String getMsg() {
        return privateVariable;
    }
}
