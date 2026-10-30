package Trees.SearchAlgo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    private static class Node {
        private int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    public Integer search(Node root, int target) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        return search(queue, target);
    }

    private Integer search(Queue<Node> queue, int target) {
        if (queue.isEmpty()) {
            return null;
        }

        Node current = queue.poll();

        if (current.left != null) {
            queue.offer(current.left);
        }

        if (current.right != null) {
            queue.offer(current.right);
        }

        if (current.value == target) {
            Node successor = queue.peek();
            return successor == null ? null : successor.value;
        }

        return search(queue, target);
    }
}