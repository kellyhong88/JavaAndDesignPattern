package com.learning.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    public static void main(String args[]) {
        generics1();
        generics2();
        generics3();
    }

    private static void generics1() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        print(intArray);
        print(doubleArray);
        print(charArray);
    }

    private static void generics2() {
        System.out.printf("%d, %d, %d 中最大的整数：%d\n", 3, 4, 5, max(3, 4, 5));
        System.out.printf("%.1f, %.1f, %.1f 中最大的浮点数：%.1f\n", 6.6, 7.7, 8.8, max(6.6, 7.7, 8.8));
        System.out.printf("%s, %s, %s 中最大的字符串：%s\n", "apple", "banana", "orange", max("apple", "banana", "orange"));
    }

    private static void generics3() {
        List<Integer> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add(365);
        list2.add(30.03);
        list3.add("strong");

        getData(list1);
        getData(list2);
        getData(list3);

        getNumber(list1);
        getNumber(list2);
    }

    /**
     * 泛型方法
     * 泛型方法的声明都有一个类型参数的声明（由尖括号分隔）
     * 该类型参数声明写在方法的返回类型之前
     * */
    private static <E> void print(E[] input) {
        for (E element: input) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    /**
     * <T extends E> 表示该泛型所代表的类型是E类型 or E类型的子类
     * <T super E> 表示该泛型所代表的类型是E类型 or E类型的父类
     * */
    private static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    /**
     * 类型通配符 ?
     * 使用 ? 代替具体的类型参数
     * 泛型类型参数需要声明，而通配符?不需要声明可直接使用
     * */
    private static void getData(List<?> data) {
        System.out.println("data: " + data.get(0));
    }

    /**
     * <? extends T> 表示该通配符所代表的类型是T类型 or T类型的子类
     * <? super T> 表示该通配符所代表的类型是T类型 or T类型的父类
     * */
    private static void getNumber(List<? extends Number> number) {
        System.out.println("number: " + number.get(0));
    }

}

