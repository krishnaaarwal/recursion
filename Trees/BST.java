package Trees;

import java.util.Scanner;

public class BST {

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        Node(int value, int height) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = height;
        }
    }

    private Node root;

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public void insert(Scanner scanner) {

        System.out.println("Enter the Root Node: ");
        int value = scanner.nextInt();

        root = new Node(value, 0);

        while (true) {
            System.out.println(
                    "Do you want to insert a node? (Enter 0 to stop, any other number to continue): "
            );

            if (scanner.nextInt() == 0) {
                break;
            }

            System.out.println("Enter the Node to insert: ");
            value = scanner.nextInt();

            root = insert(root, value, 0);
        }
    }


    private Node insert(Node node, int value, int depth) {

        if (node == null) {
            return new Node(value, depth);
        }

        if (value < node.value) {
            node.left = insert(node.left, value, depth + 1);
        }

        else {
            node.right = insert(node.right, value, depth + 1);
        }

        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left)-height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }
    // DISPLAY
    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {

        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }

            System.out.println("------>" + node.value);
        } else {
            System.out.println(node.value);
        }

        display(node.left, level + 1);
    }

    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }

    private void populateSorted(int[] nums,int s , int e){
        if(s>=e){
            return;
        }

        int mid = s + (e-s)/2;
//        this.insert(nums[mid]);
        populateSorted(nums,s,mid);
        populateSorted(nums,mid+1,e);
    }

    //TRAVERSALS
    public void preOrder(){
        System.out.println(preOrder(root));
    }

    private String preOrder(Node root) {
        if(root == null){
            return "";
        }

        return root.value + "->" + preOrder(root.left) + preOrder(root.right);
    }

    public void inOrder(){
        System.out.println(inOrder(root));
    }

    private String inOrder(Node root) {
        if(root == null){
            return "";
        }

        return inOrder(root.left) + root.value + "->"  + inOrder(root.right);
    }

    public void postOrder(){
        System.out.println(postOrder(root));
    }

    private String postOrder(Node root) {
        if(root == null){
            return "";
        }

        return postOrder(root.left) + postOrder(root.right) +root.value + "->";
    }
}