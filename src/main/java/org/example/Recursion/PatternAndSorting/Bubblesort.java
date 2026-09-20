package org.example.Recursion.PatternAndSorting;

public class Bubblesort {
    public static void main(String[] args) {

    }
    static void sort(int[] arr,int r,int c){
        if(r == 0){
            return;
        }

        if(c<r){
            if(arr[c] >arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            sort(arr, r, c+1);
        }else{
            sort(arr,r-1,0);
        }
    }
}
