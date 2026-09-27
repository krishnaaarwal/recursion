package org.example.Recursion.Practice;

import java.util.ArrayList;

public class Leetcode17 {
    public static void main(String[] args) {

        System.out.println(letterCombinations("","23",0));
        ArrayList<String> ans = new ArrayList<>();
        letterCombinations("","23",0, ans);
        System.out.println(ans);
    }

    //ArrayList in Body
    public static ArrayList<String> letterCombinations(String processed,String digits,int index) {
        if(index>=digits.length()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char c = digits.charAt(index);
        String mapped = switch (c) {
            case '2' -> "abc";
            case '3' -> "def";
            case '4' -> "ghi";
            case '5' -> "jkl";
            case '6' -> "mno";
            case '7' -> "pqrs";
            case '8' -> "tuv";
            case '9' -> "wxyz";
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };

        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<mapped.length();i++){
            char ch = mapped.charAt(i);

            ans.addAll(letterCombinations(processed + ch,digits,index+1));
        }
        return ans;
    }

    //ArrayList in args
    public static ArrayList<String> letterCombinations(String processed,String digits,int index,ArrayList<String> ans) {
        if(index>=digits.length()){
            ans.add(processed);
            return ans;
        }

        char c = digits.charAt(index);
        String mapped = switch (c) {
            case '2' -> "abc";
            case '3' -> "def";
            case '4' -> "ghi";
            case '5' -> "jkl";
            case '6' -> "mno";
            case '7' -> "pqrs";
            case '8' -> "tuv";
            case '9' -> "wxyz";
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };

        for(int i=0;i<mapped.length();i++){
            char ch = mapped.charAt(i);

            ans.addAll(letterCombinations(processed + ch,digits,index+1));
        }
        return ans;
    }
}
