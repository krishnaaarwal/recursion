package Practice.HeapsPractice.TopKElements;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    private class Points{
        int[] points;
        int distance;

        Points(int[] points,int distance){
            this.points = points;
            this.distance = distance;
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Points> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(b.distance,a.distance)
        );

        for (int[] pair : points) {
            int x = pair[0];
            int y = pair[1];

            int distance = x*x + y*y; //DISTANCE FROM ORIGIN (WITHOUT ROOT)

            Points p = new Points(pair,distance);

            if(pq.size() < k){
                pq.offer(p);
            } else if (pq.peek().distance > distance) {
                pq.poll();
                pq.offer(p);
            }
        }

        int ptr = 0;
        for (Points p : pq){
            ans[ptr++] = p.points;
        }

        return ans;
    }
}
