package Practice.HeapsPractice;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(map.get(a),map.get(b))
        );

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }


        for (int num : map.keySet()){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }


        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
