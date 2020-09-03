package com.learning.java.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringBacktrack {

    public static Map<String, String> phone = new HashMap<String, String>() {{
       put("2", "abd");
       put("3", "def");
       put("4", "ghi");
       put("5", "jkl");
       put("6", "mno");
       put("7", "pqrs");
       put("8", "tuv");
       put("9", "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;

        combinations.add("");
        for (char digit: digits.toCharArray()) {
            combinations = expand(combinations, phone.get(String.valueOf(digit)));
        }

        return combinations;
    }

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
