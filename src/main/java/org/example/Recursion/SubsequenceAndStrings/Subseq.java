package org.example.Recursion.SubsequenceAndStrings;

import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        System.out.println((subset("","abc",0)));
        ArrayList<String> ans = new ArrayList<>();
        subset("","abc",0,ans);
        System.out.println(ans);
    }
//
//    static void subset(String processed,String unprocessed,int index){
//        if(index>=unprocessed.length()){
//            System.out.println(processed);
//            return;
//        }
//
//        char c = unprocessed.charAt(index);
//
//        String takeIt = processed + c;
//
//        subset(takeIt,unprocessed,index+1);
//        subset(processed,unprocessed,index+1);
//
//    }

    static String[] subset(String processed,String unprocessed,int index,ArrayList<String> ans){
        if(index>=unprocessed.length()){
            ans.add(processed);
            return ans.toArray(new String[0]);
        }

        char c = unprocessed.charAt(index);

        String takeIt = processed + c;

        subset(takeIt,unprocessed,index+1,ans);
        subset(processed,unprocessed,index+1,ans);

        return ans.toArray(new String[0]);
    }

    static ArrayList<String> subset(String processed,String unprocessed,int index){
        if(index>=unprocessed.length()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char c = unprocessed.charAt(index);

        String takeIt = processed + c;

        ArrayList<String> left = subset(takeIt,unprocessed,index+1);
        ArrayList<String> right = subset(processed,unprocessed,index+1);

        left.addAll(right);
        return left;
    }

}
