package com.cause.base;

import java.util.HashSet;
import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random(1111);
        HashSet<String> strings = new HashSet<>();
        for (int j = 0; j < 100; j++) {
            int i = random.nextInt(9999);
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            for (int k = 0; k < chars.length; k++) {
                strings.add(String.valueOf(chars[k]));
            }
            if (strings.size() == 4) {
                System.out.println(i);
            }
        }
    }

}
