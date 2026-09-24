package org.example.Recursion.SubsequenceAndStrings;

public class SkipACharacter {
    public static void main(String[] args) {
        System.out.println(skip("baccad",'c'));
        System.out.println(skip("baccad","",'c'));
    }

    // Approach 1
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

    //Approach 2
    static String skip(String str,String ans,char target){
        if(str.equals("")){
            return ans;
        }

        char c = str.charAt(0);
        if(c == target){
            ans = ans + "";
        }else{
            ans = ans + c;
        }

        String newStr = str.substring(1,str.length());
        return skip(newStr,ans,target);
    }
}
