package org.example.Recursion.SubsequenceAndStrings;

import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
//        subset("","abc",0);
        ArrayList<String> ans = new ArrayList<>();
        subset("","abc",0,ans);
        System.out.println(ans);
    }

    static void subset(String processed,String unprocessed,int index){
        if(index>=unprocessed.length()){
            System.out.println(processed);
            return;
        }

        char c = unprocessed.charAt(index);

        String takeIt = processed + c;

        subset(takeIt,unprocessed,index+1);
        subset(processed,unprocessed,index+1);

    }

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

}
