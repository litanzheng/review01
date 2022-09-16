package com.tencent.wrapper;

import java.util.Arrays;
import java.util.Comparator;

//Arrays定制排序
public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr ={-1,1,0,8,9,10};

//        BubbleSort(arr);
        BubbleSort02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i1-i2;
            }
        });

        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                int temp = 0;
                if (arr[j]<arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //定制冒泡排序
    public static void BubbleSort02(int[] arr, Comparator c){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                int temp = 0;
                if (c.compare(arr[j],arr[j+1])>0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
