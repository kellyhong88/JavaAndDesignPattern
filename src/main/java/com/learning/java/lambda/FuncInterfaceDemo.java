package com.learning.java.lambda;

import java.util.ArrayList;

public class FuncInterfaceDemo {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }};
        ArrayList<Person> persons = map(names, Person::new);
        System.out.println(persons.get(0).getName() + persons.get(1).getName() + persons.get(2).getName());
    }

    private static <X, Y> ArrayList<Y> map(ArrayList<X> list, Function<X, Y> mapper) {
        ArrayList<Y> mappedList = new ArrayList<>();
        for (X x : list) {
            mappedList.add(mapper.apply(x));
        }
        return mappedList;
    }

}
