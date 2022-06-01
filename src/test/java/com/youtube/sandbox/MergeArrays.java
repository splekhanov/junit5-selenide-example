package com.youtube.sandbox;

import java.util.Arrays;

public class MergeArrays {

    public static void main(String[] args) {
        String[] arr1 = new String[] {"Adam", "James"};
        String[] arr2 = new String[] {"Timur"};
        String[] result = mergeArrays(arr1, arr2);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static String[] mergeArrays(String[] arr1, String[] arr2) {
        int length = (arr1.length) + (arr2.length);
        String[] result = new String[length];

        for(int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }

        for(int i = arr1.length; i < arr2.length + arr1.length; i++) {
            result[i] = arr2[i - arr1.length];
        }
        return result;
    }
}
