package org.example.Recursion.SubsequenceAndStrings;

import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
        subset("","abc",0);
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
}
