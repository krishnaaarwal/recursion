package Practice.HeapsPractice;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

        private class Element {
            int val;
            int[] list;
            int index;

            Element(int val, int[] list, int index) {
                this.val = val;
                this.list = list;
                this.index = index;
            }
        }

        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Element> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.val, b.val)
            );

            int rows = Math.min(matrix.length, k);
            for (int r = 0; r < rows; r++) {
                if (matrix[r].length != 0) {
                    pq.offer(new Element(matrix[r][0], matrix[r], 0));
                }
            }

            for (int i = 0; i < k - 1; i++) {
                Element popped = pq.poll();

                if (popped.index + 1 < popped.list.length) {
                    pq.offer(new Element(
                            popped.list[popped.index + 1],
                            popped.list,
                            popped.index + 1
                    ));
                }
            }

            return pq.poll().val;
        }

}
