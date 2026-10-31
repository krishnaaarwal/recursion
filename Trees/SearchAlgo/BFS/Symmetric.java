package Trees.SearchAlgo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {

      public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
          TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
     }
  }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if(left==null && right==null){
                    continue;
                }

                if(left == null || right == null){
                    return false;
                }

                if(left.val != right.val){
                    return false;
                }

                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
        }
        return true;
    }
}
