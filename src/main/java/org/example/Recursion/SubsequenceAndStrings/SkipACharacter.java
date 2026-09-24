package org.example.Recursion.SubsequenceAndStrings;

public class SkipACharacter {
    public static void main(String[] args) {
        //Approach 1
        System.out.println(skip("baccad",'c'));

        //Approach 2
        System.out.println(skip("baccad","",'c'));

        //Approach 3
        char[] arr = "baccad".toCharArray();

        skip(arr, 'a', 0, 0);

        System.out.println(new String(arr));
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

    //Approach 3 (In place) - Since Strings are immutable it is not possible however create an array
    static void skip(char[] arr, char target, int index, int write) {

        if (index == arr.length) {
            return;
        }

        if (arr[index] != target) {
            arr[write] = arr[index];
            write++;
        }

        skip(arr, target, index + 1, write);
    }
}
