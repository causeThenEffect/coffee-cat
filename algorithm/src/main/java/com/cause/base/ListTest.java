package com.cause.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
//            iterator.remove();
            strings.remove(next);
        }
    }

}
