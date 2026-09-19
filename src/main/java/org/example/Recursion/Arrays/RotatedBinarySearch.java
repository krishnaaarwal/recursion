package org.example.Recursion.Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {7,8,1,2,3,4,5};
        System.out.println(search(arr,3,0,arr.length-1));
    }

    static int search(int[] arr,int target,int s,int e){
        int mid = s+(e-s)/2;

        if(s>e){
            return -1;
        }
        if(arr[mid] == target){
            return mid;
        }

        if(arr[s]<=arr[mid]){
            if(target >= arr[s] && target <=arr[mid]){
                e=mid-1;
                return search(arr,target,s,e);
            }else {
                s = mid+1;
                return search(arr,target,s,e);
            }
        }else{
            if(target>=arr[mid] && target <=arr[e]){
                s=mid+1;
                return search(arr,target,s,e);
            }else{
                e=mid-1;
                return search(arr, target, s, e);
            }
        }
    }
}
