package org.example.MathsForDsa;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 36;

        for(int i=2;i<=Math.sqrt(n);i++){  //square root because after it , they will repeat. (Check on pen paper)
            if(n%i == 0){
                System.out.println("Prime");
                break;
            }
        }
    }
}
