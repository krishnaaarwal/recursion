package Recursion.PatternAndSorting.CountAndRadix;

import java.util.Arrays;

public class CountSort {
    //Count sort is good for Small number only!
    //Time complexity - O(m+n)

    public static void main(String[] args) {
        int[] arr = {3,4,1,3,2,5,2,8};

        System.out.println(sort(arr));
    }

    public static String sort(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }

        int[] frequencyArray = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            frequencyArray[num] = frequencyArray[num]+1;
        }

        int ptr = 0;
        for (int i = 0; i < frequencyArray.length; i++) {
            int freq = frequencyArray[i];
            while(freq-- > 0 && ptr < arr.length){
                arr[ptr++] = i;
            }
        }

        return Arrays.toString(arr);
    }
}
