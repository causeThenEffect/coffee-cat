package com.cause.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class S347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++orDefault);
        }

        ArrayList<Integer> list = new ArrayList<>();
        map.entrySet().forEach(e -> {
            Integer value = e.getValue();
            if (value >= k) {
                list.add(e.getKey());
            }
        });

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] i = {1, 2};
        int[] ints = S347.topKFrequent(i, 2);
        System.out.println(ints);
        new HashMap<>();
        new ConcurrentHashMap<>();
        new ThreadLocal<>();
    }

}
