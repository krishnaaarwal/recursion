package org.example.Recursion.MergeAndQuick;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        int[] arr = {11,10,9,8,7};
        mergeSort(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr,int start,int end){
        if (end - start == 1) {
            return;
        }
        int mid = start + (end - start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr,start,mid,end);
    }


    private static void merge(int[] arr,int s,int m,int e){
        int[] merged = new int[e-s];
        int ptr1=s;
        int ptr2=m;
        int ptr3=0;


        while(ptr1 < m && ptr2 < e){
            if(arr[ptr1] < arr[ptr2]){
                merged[ptr3]=(arr[ptr1]);
                ptr1++;
            }else{
                merged[ptr3]=(arr[ptr2]);
                ptr2++;
            }
            ptr3++;
        }


        while (ptr1< m){
            merged[ptr3]=arr[ptr1];
            ptr1++;
            ptr3++;
        }


        while (ptr2< e){
            merged[ptr3]=arr[ptr2];
            ptr2++;
            ptr3++;
        }

        for (int l=0;l<merged.length;l++){
            arr[s+l] = merged[l];
        }
    }

}
