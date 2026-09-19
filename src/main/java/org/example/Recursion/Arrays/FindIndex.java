package org.example.Recursion.Arrays;

import java.util.ArrayList;

public class FindIndex {
    public static void main(String[] args) {
        int[] arr= {1,4,3,4,4,5};
        System.out.println(findIndex(arr,2,0));
    }

    static ArrayList findIndex(int[] arr,int target,int index){
        ArrayList<Integer> list = new ArrayList<>();

        if(index== arr.length){
            return list;
        }

        //this will contain answer from that function call only
        if(arr[index] == target){
            list.add(index);
        }

        ArrayList answerFromBelow = findIndex(arr,target,index+1);
        if(!list.isEmpty()){
            answerFromBelow.add(index);
        }
         return answerFromBelow;
    }
}
