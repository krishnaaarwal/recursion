package org.example.Bitwise;

public class FindUnique {
    public static void main(String[] args) {

        /*
        When you XOR a number with itself it will give zero,
        When you XOR a number with zero it will give the number itself.

        Now using this concept, we start xor ing the numbers of array with
        zero. Since xor follow same commulative, assosiative propertiies
        like multiplication , ordering of xor will not be problem.

        Hence , if we XOR all number , duplicate numbers will make zero itself,
        and unique number will left , in last it will xor to zero and
        hence the number unique will be found.
        */
        int[] arr = {1,2,3,4,5,5,6,3,4,1,2};
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = arr[i] ^ ans;
        }
        System.out.println(ans);
    }
}
