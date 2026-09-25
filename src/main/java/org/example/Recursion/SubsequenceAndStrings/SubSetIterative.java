package org.example.Recursion.SubsequenceAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetIterative {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = subsetWithDuplicate(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subsetWithDuplicate(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {

            start = 0;

            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;

            for (int j = start; j <= end; j++) {

                List<Integer> internal =
                        new ArrayList<>(outer.get(j));

                internal.add(arr[i]);

                outer.add(internal);
            }
        }

        return outer;
    }


//    static List<List<Integer>> subset(int[] arr){
//        List<List<Integer>> outerList = new ArrayList<>();
//        outerList.add(new ArrayList<>());  //Empty List added in outerlist
//
//        for(int i=0;i< arr.length;i++){
//            int size = outerList.size();
//            int num = arr[i];
//            for(int j=0;j<size;j++){
//                List<Integer> internalList = new ArrayList<>(outerList.get(j));
//                internalList.add(num);
//                outerList.add(internalList);
//            }
//        }
//
//        return outerList;
//    }
}
