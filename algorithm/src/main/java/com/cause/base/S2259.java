package com.cause.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class S2259 {

    public static String removeDigit(String number, char digit) {
        String temp = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String newString = number.substring(0, i) + number.substring(i + 1);
                if (temp.compareTo(newString) < 1) {
                    temp = newString;
                }
            }
        }

        return temp + "";
    }

    public static void main(String[] args) {
//        String s = S2259.removeDigit("1321", '1');
//        System.out.println(s);
//        new StringBuilder();
//        new ConcurrentHashMap<>();
//        new AtomicInteger();
//        String s1 = new StringBuilder().append("").toString();
//        String intern = s1.intern();
//        new ThreadLocal<>();
//        new HashMap<>();
//        new ReentrantLock(true);
//        new CopyOnWriteArrayList();
//        new LinkedHashMap<>();
//        new CountDownLatch(5);
        new PriorityQueue<>();
        int[] aa = new int[]{1, 2, 54, 23, 65, 7};
        int[] t = S2259.t(aa, 3);
        Arrays.stream(t).forEach(System.out::println);
    }

    private static int[] t(int[] a, int n) {
        int[] b = new int[n + 1];

        for (int i = 0; i < a.length; i++) {
            if (b[1] < a[i]) {
                b[1] = a[i];
                // 自顶向下堆化
                int j = 1;
                int k = 1;
                while (true) {
                    if (j * 2 < n + 1 && b[j] > b[j * 2]) {
                        k = j * 2;
                    }
                    if (j * 2 + 1 < n + 1 && b[k] > b[j * 2 + 1]) {
                        k = j * 2 + 1;
                    }
                    if (k == j) {
                        break;
                    } else {
                        int t = b[k];
                        b[k] = b[j];
                        b[j] = t;
                        j = k;
                    }
                }
            }
        }

        return b;
    }

}
