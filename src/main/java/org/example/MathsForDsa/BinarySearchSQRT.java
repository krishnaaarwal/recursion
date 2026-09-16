package org.example.MathsForDsa;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int n = 40;
        int p = 3;

        System.out.println(sqrt(n,p));
    }

    static double sqrt(int n , int p){
        int start = 0;
        int end = n;
        double root = 0.0;
        while(start<end){
            int mid = start + (end-start)/2;

            if(mid*mid<n){
                end=mid-1;
            }else if(mid*mid>n){
                start=mid+1;
            }else{
                return mid;
            }
        }

        // FOR PRECISION OF POINTS
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while(root*root<=n){
                root = root + incr;
            }
            root = root - incr;
            incr = incr/10;
        }
        return root;

    }
}
