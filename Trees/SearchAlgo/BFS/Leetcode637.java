package Trees.SearchAlgo.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode637 {

    private static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
        }
    }

    public List<Double> averageOfLevels(Node root) {
        List<Double> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0.0;

            for(int i=0;i<size;i++){
                Node current = queue.poll();

                sum +=current.value;

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }

            }

            double avg = sum / size;

            ans.add(avg);
        }

        return ans;
    }

}
