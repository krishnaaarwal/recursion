package Trees;

public class Main {
    public static void main(String[] args) {

        AVL avl = new AVL();

        int[] nums = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        avl.populate(nums);

        System.out.println("Number of nodes: " + nums.length);
        System.out.println("Height of AVL tree: " + avl.height());
        System.out.println("Is balanced: " + avl.balanced());
    }
}