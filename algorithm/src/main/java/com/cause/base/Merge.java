package com.cause.base;

public class Merge {

    private void sort(int[] a) {
        sort(a, 0, a.length);
    }

    private void sort(int[] a, int s, int e) {
        if (s >= e) {
            return;
        }

        int mid = e / 2;
        sort(a, s, mid);
        sort(a, mid + 1, e);

        int temp[] = new int[a.length];
        int count = 0;
        int i = s;
        int j = mid;
        while (i <= mid) {
            if (a[i] < a[j]) {
                temp[count++] = a[i++];
            } else {
                temp[count++] = a[j++];
            }
        }

        for (int k = 0; k < count; k++) {
            a[s++] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 6, 3, 7, 9, 1};
        Merge merge = new Merge();
        merge.sort(a);
        System.out.println(a);
    }

}
