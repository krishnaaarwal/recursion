package org.example.Recursion.Permutations;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println((permutation("","abcd",0)));

        ArrayList<String> ans = new ArrayList<>();
        permutation("","abcd",0,ans);
        System.out.println(ans);

        System.out.println((permutationCount("","abcd",0)));
    }

    //Printing
    static void permutationPrint(String processed,String unprocessed,int index){
        if(index >=unprocessed.length()){
            System.out.println(processed);
            return;
        }

        int n = processed.length() + 1;
        char c = unprocessed.charAt(index);

        for(int i=0;i<n;i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());

            String permutation =  first + c + second;
            permutationPrint(permutation,unprocessed,index+1);
        }
    }

    // Passing ArrayList as argument
    static ArrayList<String> permutation(String processed, String unprocessed, int index, ArrayList<String> ans){
        if(index >=unprocessed.length()){
              ans.add(processed);
              return ans;
        }

        int n = processed.length() + 1;
        char c = unprocessed.charAt(index);

        for(int i=0;i<n;i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());

            String permutation =  first + c + second;
            permutation(permutation,unprocessed,index+1,ans);
        }
        return ans;
    }

    //In body ArrayList
    static ArrayList<String> permutation(String processed,String unprocessed,int index){
        if(index >=unprocessed.length()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int n = processed.length() + 1;
        char c = unprocessed.charAt(index);

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());

            String permutation =  first + c + second;
            ArrayList<String> prev = permutation(permutation,unprocessed,index+1);

            ans.addAll(prev);
        }
        return ans;
    }

    //Count
        static int permutationCount(String processed,String unprocessed,int index){
        if(index >=unprocessed.length()){
            return 1;
        }

        int n = processed.length() + 1;
        char c = unprocessed.charAt(index);

        int count = 0;
        for(int i=0;i<n;i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());

            String permutation =  first + c + second;
            count = count + permutationCount(permutation,unprocessed,index+1);
        }
        return count;
    }
}
