package Practice.HeapsPractice.MedianInStream;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();

        int leftSize = 0;
        int rightSize = 0;

        for (int i = 0; i < k; i++) {
            left.offer(nums[i]);
            leftSize++;

            right.offer(left.poll());
            leftSize--;
            rightSize++;

            if (rightSize > leftSize) {
                left.offer(right.poll());
                rightSize--;
                leftSize++;
            }
        }

        double[] ans = new double[nums.length - k + 1];
        ans[0] = getMedian(left, right, k);

        int ptr1 = 0;
        int ptr2 = k;

        while(ptr2 < nums.length){
            int deleted = nums[ptr1++];
            int added = nums[ptr2++];

            if (!left.isEmpty() && added <= left.peek()) {
                left.offer(added);
                leftSize++;
            } else {
                right.offer(added);
                rightSize++;
            }

            map.put(deleted, map.getOrDefault(deleted, 0) + 1);
            if (deleted <= left.peek()) {
                leftSize--;
                prune(left,map);
            } else {
                rightSize--;
                prune(right,map);
            }



            if (rightSize > leftSize) {
                prune(right, map);
                left.offer(right.poll());
                rightSize--;
                leftSize++;
            } else if (leftSize > rightSize + 1) {
                prune(left, map);
                right.offer(left.poll());
                leftSize--;
                rightSize++;
            }

            prune(left, map);
            prune(right, map);

            ans[ptr1] = getMedian(left, right, k);
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
