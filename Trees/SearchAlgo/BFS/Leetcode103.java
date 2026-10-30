package Trees.SearchAlgo.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode103 {
    private static class Node{
        private int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        int count = 1;

        while(!deque.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = deque.size();


            for(int i = 0;i<size;i++){
                if(count % 2 != 0){
                    Node current = deque.removeFirst();
                    list.add(current.val);

                    if(current.left!=null){
                        deque.addLast(current.left);
                    }
                    if(current.right!=null){
                        deque.addLast(current.right);
                    }
                }else{
                    Node current = deque.removeLast();
                    list.add(current.val);

                    if(current.right!=null){
                        deque.addFirst(current.right);
                    }
                    if(current.left!=null){
                        deque.addFirst(current.left);
                    }

                }
            }
            count++;
            ans.add(list);

        }
        return ans;
    }
}
