package org.example.Recursion.PatternAndSorting;

public class Sorting {
    public static void main(String[] args) {
        int[] arr= {3,4,1,2};
        selectionSort(arr, arr.length-1, 0,Integer.MIN_VALUE);
        System.out.println(arr.toString());
    }
    static void bubbleSort(int[] arr,int r,int c){
        if(r == 0){
            return;
        }
        if(c<r){
            int temp = arr[c];
            arr[c] = arr[c+1];
           arr[c+1] = temp;
            bubbleSort(arr, r, c+1);
        }else{
            bubbleSort(arr,r-1,0);
        }
    }

    static void selectionSort(int[] arr, int r, int c, int max) {

        if (r == 0) {
            return;
        }

        if (c < r) {

            if (arr[c] > arr[max]) {
                max = c;
            }

            selectionSort(arr, r, c + 1, max);

        } else {

            int temp = arr[max];
            arr[max] = arr[r];
            arr[r] = temp;

            selectionSort(arr, r - 1, 0, 0);
        }
    }
}
