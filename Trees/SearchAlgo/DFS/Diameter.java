
package Trees.SearchAlgo.DFS;

public class Diameter {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Calculate the diameter passing through this node
        int currentDiameter = leftHeight + rightHeight + 2;

        // Keep the maximum diameter found so far
        diameter = Math.max(diameter, currentDiameter);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}