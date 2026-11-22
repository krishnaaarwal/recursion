package Practice.HeapsPractice;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        for (String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    int freqCompare = Integer.compare(map.get(a), map.get(b));
                    if (freqCompare != 0) {
                        return freqCompare;
                    }
                    return b.compareTo(a); // Alphabetically larger at root (evicted first)
                }
        );

        for (String word : map.keySet()){
            pq.offer(word);

            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        Collections.reverse(list);

        return list;
    }
}
