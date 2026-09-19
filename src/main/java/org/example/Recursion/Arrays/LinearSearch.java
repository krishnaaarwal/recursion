package org.example.Recursion.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr= {1,6,7,8,34,-1};
        System.out.println(search(arr,-1,0));
    }
    static int search(int[] arr,int target,int i){
        if(arr[i]==target){
            return i;
        }

        if(i< arr.length){
            return search(arr,target,i+1);
        }
        return -1;
    }
}
