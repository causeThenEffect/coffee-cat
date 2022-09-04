package com.cause.base;

public class Test {

    private static long a(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return a(n - 1) + a(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 64));
        System.out.println(a(45));
        System.out.println(a(47));
    }

}
