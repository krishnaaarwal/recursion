package org.example.Recursion.SimpleRecursion;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(78));
    }
    static int reverse(int n){
        if(n<10){
            return n;
        }
        int lastDigit = n%10;
        int count = (int)(Math.log10(n));
        int reverse = lastDigit * (int)(Math.pow(10, count));
        return reverse + reverse(n/10);
    }
}
