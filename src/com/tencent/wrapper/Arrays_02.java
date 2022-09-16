package com.tencent.wrapper;

import java.util.Arrays;

public class Arrays_02 {
    public static void main(String[] args) {
        Integer[] arr={10,12,34,45,65};
        //-(low+1)
        int i = Arrays.binarySearch(arr, 11);
        System.out.println(i);
        Integer[] integers = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(integers));

    }
}
