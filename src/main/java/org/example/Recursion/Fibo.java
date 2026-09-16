package org.example.Recursion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Fibo {
    public static void main(String[] args) {
        int ans = fibo(10);
        System.out.println(ans);
    }

    static int fibo(int n){
        if(n<2){
            return n;
        }
        return fibo(n-2) + fibo(n-1);
    }
}