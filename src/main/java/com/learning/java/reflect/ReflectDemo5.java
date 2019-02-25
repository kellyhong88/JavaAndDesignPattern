package com.learning.java.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过Class，Method来认识范型的本质
 */
public class ReflectDemo5 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> stringList = new ArrayList<String>();

        Class c1 = list.getClass();
        Class c2 = stringList.getClass();
        System.out.println(c1 == c2);

        /**
         * 反射的操作都是编译之后的操作（对字节码的操作）
         *
         * c1 == c2 说明编译之后集合的范型是去范型化的
         * java中集合的范型，是防止错误输入的，只在编译阶段有效，编译之后就无效了
         * */

        /**
         * 验证：我们可以通过方法的反射来绕过编译
         * */
        try {
            Method method = c2.getMethod("add", Object.class);
            method.invoke(stringList, "Save yourself");
            method.invoke(stringList, 100d);
            method.invoke(stringList, new Object());
            System.out.println(stringList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
