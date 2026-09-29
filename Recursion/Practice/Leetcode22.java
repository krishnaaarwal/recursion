package Recursion.Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(8));
    }
        public static List<String> generateParenthesis(int n) {
            ArrayList<String> ans = new ArrayList<>();
            HashSet<String> hash = new HashSet<>();
            parenthesis("",n,ans,hash);
            return ans;
        }
        static ArrayList<String> parenthesis(
                String pr,
                int n,
                ArrayList<String> ans,
                HashSet<String> hash) {

            if (n == 0) {
                if (!ans.contains(pr)) {
                    ans.add(pr);
                }
                return ans;
            }

            for (int i = 0; i <= pr.length(); i++) {

                String first = pr.substring(0, i);
                String second = pr.substring(i);

                String formed = first + "()" + second;
                if(!hash.contains(formed)){
                    hash.add(formed);
                parenthesis(
                        formed,
                        n - 1,
                        ans,
                        hash
                );
                }
            }

            return ans;
        }

}
