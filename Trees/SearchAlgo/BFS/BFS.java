package Trees.SearchAlgo.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BFS {
    private static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
        }
    }

//    public void bfs(Node node, Deque<Node> queue){
//        if(node == null){
//            return;
//        }
//
//        System.out.print(node.value + "->");
//
//        if (node.left != null) {
//            queue.add(node.left);
//        }
//
//        if (node.right != null) {
//            queue.add(node.right);
//        }
//
//        bfs(queue.poll(),queue);
//    }

    public ArrayList<Integer> bfs(Node node, Deque<Node> queue, ArrayList<Integer> array){
        if(node == null){
            return array;
        }

        array.add(node.value);

        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }

        bfs(queue.poll(),queue,array);

        return array;
    }

    public ArrayList<Integer> bfs(Node node, Deque<Node> queue) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (node == null) {
            return ans;
        }

        ans.add(node.value);

        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }

        if (!queue.isEmpty()) {
            ans.addAll(bfs(queue.poll(), queue));
        }

        return ans;
    }
}
