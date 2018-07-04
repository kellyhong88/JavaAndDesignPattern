package com.learning.java.reflect;

/**
 * 编译时加载类是静态加载类
 * 运行时加载类是动态加载类
 * <p>
 * 用new来创建对象是静态加载类
 * 即在编译时刻就需要加载所有可能使用到的类
 * <p>
 * 通过动态加载类可以解决该问题
 * Class.forName()是动态加载类
 */
public class Office {

    public static void main(String[] args) {
        try {
            for (String arg : args) {
                Class c = Class.forName(arg);
                OfficeAble oa = (OfficeAble) c.newInstance();
                oa.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
