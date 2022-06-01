package com.youtube.sandbox;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,33,76,3};
        int[] result = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--) {
            result[arr.length - 1 - i] = arr[i];
        }
    }
}
