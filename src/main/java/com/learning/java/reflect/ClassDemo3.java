package com.learning.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo3 {

    /**
     * 打印类的信息
     * 包括类的名称、成员变量、成员函数、构造函数等
     */
    public static void printClassInfo(Object object) {

        /**
         * c是传入对象object的类对象的引用
         * */
        Class c = object.getClass();

        /**
         * 获取方法的全名（包含类的package路径）
         * 以及方法的简名（不包含类的package路径）
         * */
        System.out.println("类的名称---------------------------------------------------");
        System.out.println("类的全名：" + c.getName());
        System.out.println("类的简名：" + c.getSimpleName());
        System.out.println("----------------------------------------------------------\n");

        /**
         * 万事万物皆对象
         * 方法也是对象
         * 方法是java.lang.reflect.Method类的对象
         *
         * 一个成员方法就是一个Method对象
         *
         * getMethods()获取该类的所有public函数，包括从父类继承而来的方法
         * getDeclaredMethods()获取该类的所有自己声明的方法，不论访问权限，但不包括从父类继承而来的方法
         * */
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();

        System.out.println("类的成员方法------------------------------------------------");
        for (Method method : methods) {
            /**
             * 获取方法的返回值类型的类类型
             * */
            Class returnType = method.getReturnType();
            System.out.print(returnType.getSimpleName() + " ");
            /**
             * 获取方法名
             * */
            System.out.print(method.getName() + "(");
            /**
             * 获取参数类型（参数的类类型数组）
             * */
            Class[] paramTypes = method.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getSimpleName() + ", ");
            }
            System.out.println(")");
        }
        System.out.println("----------------------------------------------------------\n");

        /**
         * 万事万物皆对象
         * 成员变量也是对象
         * 成员变量是java.lang.reflect.Field类的对象
         *
         * 一个成员变量就是一个Field对象
         *
         * getFields()获取该类的所有public变量，包括从父类继承而来的变量
         * getDeclaredFields()获取该类的所有自己定义的变量，不论访问权限，但不包括从父类继承而来的变量
         * */
        Field[] fields = c.getFields();
        Field[] declaredFields = c.getDeclaredFields();

        System.out.println("类的成员变量------------------------------------------------");
        for (Field field : fields) {
            /**
             * 获取成员变量的类的类类型
             * */
            Class fieldType = field.getType();
            /**
             * 得到成员变量类型的名字
             * */
            System.out.print(fieldType.getSimpleName() + " ");
            /**
             * 得到成员变量自己的名字
             * */
            System.out.println(field.getName());
        }
        System.out.println("----------------------------------------------------------\n");

        /**
         * 万事万物皆对象
         * 构造函数也是对象
         * 构造函数是java.lang.Constructor类的对象
         *
         * 一个构造函数是一个Constructor对象
         *
         * getConstructors()获取类的所有public构造函数
         * getDeclaredConstructors()获取类的所有构造函数，不论访问权限
         * */
        Constructor[] constructors = c.getConstructors();
        Constructor[] declaredConstructors = c.getDeclaredConstructors();

        System.out.println("类的构造方法------------------------------------------------");
        for (Constructor constructor : declaredConstructors) {
            /**
             * 获取构造函数的方法名
             * */
            System.out.print(constructor.getName() + " (");
            /**
             * 获取构造函数的参数列表（参数的类类型数组）
             * */
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getSimpleName() + ", ");
            }
            System.out.println(")");
        }
        System.out.println("---------------------------------------------------------\n");

    }

    public static void main(String[] args) {
        ClassDemo3.printClassInfo("hello");
//        ClassDemo3.printClassInfo(new Integer(1));
//        ClassDemo3.printClassInfo(new Object());
//        ClassDemo3.printClassInfo(new ArrayList<>());
//        ClassDemo3.printClassInfo(new HashMap<>());
    }
}
