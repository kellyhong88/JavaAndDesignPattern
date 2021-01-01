package com.learning.java.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 非智能手机键盘: 参考resources/photos下的phone_keyboard.png
 * */
public class PhoneKeyboard {

    /**
     * 把手机键盘的信息存储为map结构
     * */
    public static Map<String, String> phone = new HashMap<String, String>() {{
       put("2", "abc");
       put("3", "def");
       put("4", "ghi");
       put("5", "jkl");
       put("6", "mno");
       put("7", "pqrs");
       put("8", "tuv");
       put("9", "wxyz");
    }};

    /**
     * 给到数字组合，如："23"
     * 求：在每个数字指代的字符串中选一个字符，组合在一起的所有情况
     * 如：ad,ae,af,bd,be,bf,cd,ce,cf
     * */
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;

        /**
         * 第1轮遍历，当前数字指代的字符串在expand()方法中与""结合
         * */
        combinations.add("");
        for (char digit: digits.toCharArray()) {
            combinations = expand(combinations, phone.get(String.valueOf(digit)));
        }

        return combinations;
    }

    /**
     * 给到上一轮遍历后的组合结果，如：{a,b,c}
     * 结合当前数字的字符串，如："def"
     * 得到新一轮遍历后的新组合结果，如：{ad,ae,af,bd,be,bf,cd,ce,cf}
     * */
    public static List<String> expand(List<String> now, String reflect) {
        List<String> after = new ArrayList<>();
        for (String s: now) {
            for (char r: reflect.toCharArray()) {
                after.add(s + r);
            }
        }
        return after;
    }

    public static void main(String[] args) {
        System.out.println("Combinations of 23 on the phone map: " + letterCombinations("23"));
        System.out.println("Combinations of 234 on the phone map: " + letterCombinations("234"));
        System.out.println("Combinations of 2349 on the phone map: " + letterCombinations("2349"));
    }

}
