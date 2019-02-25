package com.learning.java.reflect;

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
            Method method = hClass.getDeclaredMethod("privateMethod", String.class, int.class);
            if (method != null) {
                /**
                 * 获取私有方法的访问权
                 * 注意：这里只是获取访问权，并不是修改方法的实际权限（即原方法还是private权限）
                 * */
                method.setAccessible(true);
                method.invoke(hope, "Java Reflect ", 666);
            }
        } catch (Exception e) {}

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
