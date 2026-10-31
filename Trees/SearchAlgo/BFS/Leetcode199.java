package Trees.SearchAlgo.BFS;

import java.util.*;

public class Leetcode199 {
    private class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size -1 ;i++){
                TreeNode current = queue.poll();

                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            TreeNode rightMost = queue.poll();
            if(rightMost.left!=null){
                queue.offer(rightMost.left);
            }
            if(rightMost.right!=null){
                queue.offer(rightMost.right);
            }
            ans.add(rightMost.val);
        }
        return ans;
    }
}
