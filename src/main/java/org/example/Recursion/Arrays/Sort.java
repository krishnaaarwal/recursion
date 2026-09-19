package org.example.Recursion.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {-1,0,-2};
        System.out.println(isSorted(arr));
    }

    static boolean isSorted(int[] arr){
        return isSortedHelper(arr,0);
    }

    private static boolean isSortedHelper(int[] arr,int index){
        if(index== arr.length-1){
            return true;
        }

        return arr[index] <arr[index+1] && isSortedHelper(arr,index+1);
    }
}
