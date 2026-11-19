package AdvPractice;

import java.util.*;

public class Leetcode127 {
    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        java.util.List<String> wordList = new java.util.ArrayList<>(java.util.Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        System.out.println(ladderLength(beginWord,endWord,wordList));
    }


    // O(N ^ 2 * 26)  -- Time complexity
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            Set<String> set = new HashSet<>(wordList);

            if (!set.contains(endWord)) {
                return 0;
            }

            int length = 0;

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            set.remove(beginWord);

            while (!queue.isEmpty()) {

                int size = queue.size();
                length++;

                for (int i = 0; i < size; i++) {

                    String current = queue.poll();

                    for (int j = 0; j < current.length(); j++) {

                        char[] temp = current.toCharArray();

                        for (char c = 'a'; c <= 'z'; c++) {

                            temp[j] = c;

                            String newWord = new String(temp);

                            if (set.contains(newWord)) {

                                if (newWord.equals(endWord)) {
                                    return length + 1;
                                }

                                queue.offer(newWord);
                                set.remove(newWord);
                            }
                        }
                    }
                }
            }

            return 0;
        }



    /*

    //THIS APPROACH - Check set and valid string. TIME COMPLEXITY - O(N ^2 * L)
    //Comparing each word: O(L)

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        int length = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if(current.equals(endWord)){
                    return length;
                }
                check(set,queue, current);
            }
        }
      return 0;
    }

    private void check(Set<String> set, Queue<String> queue, String beginWord) {

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();

            if (check(s, beginWord)) {
                queue.offer(s);
                iterator.remove();
            }
        }
    }

    private boolean check(String begin, String adj) {
        int diff = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != adj.charAt(i)) {
                diff++;

                if (diff > 1) {
                    return false;
                }
            }
        }

        return diff == 1;
    }

    */

    //MY BAD AND WRONG APPROACH

    /*
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        return helper( beginWord,  endWord, wordList, 0,0,0);
    }

    private static int helper(String beginWord, String endWord, List<String> wordList, int i,int length,int max) {
        String adj = wordList.get(i);
        if(adj.equals(endWord)){
            return length;
        }

        if(beginWord.length() == adj.length() && check(beginWord,adj)){
            while(i < wordList.size()){
                max = Math.max(helper(adj,endWord,wordList,i+1,length+1,max),max);
            }
        }else{
            return 0;
        }

        return max;
    }

    private static boolean check(String begin,String adj){
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != adj.charAt(i)){
                diff++;
                if(diff > 1){
                    return false;
                }
            }
        }
        return true;
    }


    */
}
