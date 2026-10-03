package Recursion.MorePractice;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxWithIndex {
    /*
     Recursive Maximum with Index
Given an integer array, recursively find the maximum element and its index.
Example:
[4, 9, 2, 17, 6, 3]

17 at index 3

Constraint: You cannot use a loop.
     */

    public static void main(String[] args) {
        int[] arr = {19, 9, 2, 17, 6, 3};
        int[] ans = new int[2];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = -1;
        max(arr,0,ans);
        System.out.println(Arrays.toString(ans));
    }

    static int[] max(int[] arr ,int index,int[] ans){
        if(arr.length == 0){
            return ans;
        }

        if(index == arr.length){
            return ans;
        }

        if(arr[index] > ans[0]){
            ans[0] = arr[index];
            ans[1] = index;
        }


        return max(arr,index+1,ans);
    }
}
