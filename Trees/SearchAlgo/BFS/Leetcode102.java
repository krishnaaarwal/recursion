package Trees.SearchAlgo.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode102 {
    private static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
        }
    }

    //LEETCODE - 102   (RECURSIVELY)

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            Deque<Node> queue = new ArrayDeque<>();
            queue.add(root);

            bfs(queue, ans);

            return ans;
        }

        private void bfs(Deque<Node> queue, List<List<Integer>> ans) {
            if (queue.isEmpty()) {
                return;
            }

            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            list.addAll(level(list,queue,size));

            ans.add(list);

            bfs(queue,ans);
        }

        private List<Integer> level(List<Integer> list, Deque<Node> queue, int size){
            if(size == 0){
                return list;
            }

            Node current = queue.poll();
            list.add(current.value);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
            return level(list, queue, size-1);
        }



    //LEETCODE - 102 (Iterative)
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        if (root == null) {
//            return ans;
//        }
//
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            List<Integer> list = new ArrayList<>();
//            int size = queue.size();
//
//            for(int i=0;i<size;i++){
//
//                TreeNode current = queue.poll();
//                list.add(current.val);
//
//                if(current.left!=null){
//                    queue.add(current.left);
//                }
//                if(current.right!=null){
//                    queue.add(current.right);
//                }
//
//            }
//
//            ans.add(list);
//
//        }
//        return ans;
//    }
}
