package Practice.HeapsPractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();

        int minSize = 0;
        int maxSize = 0;

        for (int i = 0; i < k; i++) {
            min.offer(nums[i]);
            minSize++;

            max.offer(min.poll());
            minSize--;
            maxSize++;

            if (maxSize > minSize) {
                min.offer(max.poll());
                maxSize--;
                minSize++;
            }
        }

        double[] ans = new double[nums.length - k + 1];
        ans[0] = getMedian(min, max, k);

        int ptr1 = 0;
        int ptr2 = k;

        while(ptr2 < nums.length){
            int deleted = nums[ptr1++];
            int added = nums[ptr2++];

            map.put(deleted, map.getOrDefault(deleted, 0) + 1);
            if (deleted >= min.peek()) {
                minSize--;
            } else {
                maxSize--;
            }

            if (!min.isEmpty() && added >= min.peek()) {
                min.offer(added);
                minSize++;
            } else {
                max.offer(added);
                maxSize++;
            }

            if (maxSize > minSize) {
                prune(max, map);
                min.offer(max.poll());
                maxSize--;
                minSize++;
            } else if (minSize > maxSize + 1) {
                prune(min, map);
                max.offer(min.poll());
                minSize--;
                maxSize++;
            }

            prune(min, map);
            prune(max, map);

            ans[ptr1] = getMedian(min, max, k);
        }
        return ans;
    }

    private void prune(PriorityQueue<Integer> heap, HashMap<Integer, Integer> map) {
        while (!heap.isEmpty() && map.containsKey(heap.peek())) {
            int ghost = heap.poll();
            int count = map.get(ghost);
            if (count == 1) {
                map.remove(ghost);
            } else {
                map.put(ghost, count - 1);
            }
        }
    }

    private double getMedian(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int k) {
        if (k % 2 == 1) {
            return (double) min.peek();
        }

        return ((double) min.peek() + max.peek()) / 2.0;
    }
}
