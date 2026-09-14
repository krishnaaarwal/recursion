package org.example;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,3,4,1,2};
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = arr[i] ^ ans;
        }
        System.out.println(ans);
    }
}
