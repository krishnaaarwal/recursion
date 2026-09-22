package org.example.Recursion.MergeAndQuick;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {11,10,9,8,7};
        int[] sorted = mergeSort(arr);
        int[] sorted2 = mergeSort2(arr,0, arr.length);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(sorted2));
    }

    //Making copy of array
    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    //Index boundary based approach
    static int[] mergeSort2(int[] arr,int start,int end){
        if (end - start == 1) {
            return new int[]{arr[start]};
        }
        int mid = start + (end - start)/2;

        int[] left = mergeSort2(arr, start, mid);
        int[] right = mergeSort2(arr, mid, end);

        return merge(left,right);
    }


    private static int[] merge(int[] left,int[] right){
        int ptr1=0;int ptr2=0;int ptr3=0;
        int[] merged = new int[left.length + right.length];


        while(ptr1 < left.length && ptr2 < right.length){
            if(left[ptr1] < right[ptr2]){
                merged[ptr3]=(left[ptr1]);
                ptr1++;
            }else{
                merged[ptr3]=(right[ptr2]);
                ptr2++;
            }
            ptr3++;
        }


            while (ptr1< left.length){
                merged[ptr3]=(left[ptr1]);
                ptr1++;
                ptr3++;
            }


            while (ptr2< right.length){
                merged[ptr3]=(right[ptr2]);
                ptr2++;
                ptr3++;
            }

        return merged;
    }

}
