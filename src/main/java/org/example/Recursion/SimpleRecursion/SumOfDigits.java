package org.example.Recursion.SimpleRecursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1001));
    }
    static int sumOfDigits(int n){
        if(n<10){
            return n;
        }

        return n%10 + sumOfDigits(n/10);
    }
}
