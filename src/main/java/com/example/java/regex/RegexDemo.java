package com.example.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String args[]) {
        regex1();
        regex2();
    }

    private static void regex1() {
        String content = "I am a noob from runoob.com";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);

        System.out.println("Does the content contain 'runoob' ? " + isMatch);
    }

    private static void regex2() {
        String content = "This order is placed for QT3000! OK?";

        String pattern = "(\\D*)(\\d+)(.*)";  //此处的\\不是为了转义而取得\，而是在" "里的转义

        /**
         * Pattern类没有公共构造方法
         * 要创建一个Pattern对象，必须调用其公共静态编译方法，方法接受一个正则表达式作为参数
         * */
        Pattern r = Pattern.compile(pattern);

        /**
         * Matcher类也没有公共构造方法
         * 需要调用一个Pattern对象的matcher方法来获得一个Matcher对象
         * */
        Matcher m = r.matcher(content);

        if (m.find()) {
            System.out.println("Find match: " + m.group(0));  //一个特殊的组group(0)，它总是代表整个表达式
            System.out.println("Find match: " + m.group(1));
            System.out.println("Find match: " + m.group(2));
            System.out.println("Find match: " + m.group(3));
        } else {
            System.out.println("No Match");
        }
    }


}
