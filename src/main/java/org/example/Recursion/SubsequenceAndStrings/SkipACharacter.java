package org.example.Recursion.SubsequenceAndStrings;

public class SkipACharacter {
    public static void main(String[] args) {
        System.out.println(skip("baccad",'c'));
    }

    static String skip(String str,char target){
        return skip(str,target,0);
    }

    static String skip(String str,char target, int index){
        if(index >= str.length()){
            return "";
        }

        char c = str.charAt(index);

        if(c == target){
             return "" +  skip(str,target,index+1);
        }else{
            //Internally character c converted to String
            return c + skip(str,target,index+1);
        }
    }
}
