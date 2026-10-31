package Trees.SearchAlgo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins {
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

    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                Boolean xFound = false;
                Boolean yFound = false;

                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();

                    // Check whether x and y are siblings
                    if (current.left != null && current.right != null) {
                        if ((current.left.val == x && current.right.val == y) ||
                                (current.left.val == y && current.right.val == x)) {
                            return false;
                        }
                    }
                    if (current.val == x) {
                        xFound = true;
                    }
                    if (current.val == y) {
                        yFound = true;
                    }

                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                if (xFound && yFound) {
                    return true;
                }

                // Only one node was found at this level
                if (xFound || yFound) {
                    return false;
                }

            }
            return false;
        }
    }
}
