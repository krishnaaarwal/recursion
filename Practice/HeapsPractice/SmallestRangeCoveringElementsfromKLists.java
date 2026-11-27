package Practice.HeapsPractice;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsfromKLists {

    private class Element{
        int value;
        int listIndex;
        int elementIndex;

        Element(int value,int listINdex,int elementIndex){
            this.value = value;
            this.listIndex = listINdex;
            this.elementIndex = elementIndex;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.value,b.value)
        );

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int ptr = 0;
        for(List<Integer> list : nums){
            if(list.size() != 0){
                int val = list.get(0);

                Element element = new Element(val,ptr,0);
                pq.offer(element);
                max = Math.max(max,val);
            }
            ptr++;
        }

        int bestStart = pq.peek().value;
        int bestEnd = max;


        while (!pq.isEmpty()){
            Element polled = pq.poll();

            min = polled.value;

            if(bestEnd - bestStart > max - min){
                bestEnd = max;
                bestStart = min;
            }

            int nextIndex = polled.elementIndex + 1;

            if(nextIndex == nums.get(polled.listIndex).size()){
                break;
            }

            Element nextElement = new Element(
                    nums.get(polled.listIndex).get(nextIndex),
                    polled.listIndex,
                    nextIndex
            );

            pq.offer(nextElement);
            max = Math.max(nextElement.value,max);


        }

        return new int[] {bestStart,bestEnd};
    }
}
