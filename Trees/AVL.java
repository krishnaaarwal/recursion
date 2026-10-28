package Trees;

import java.util.Scanner;

public class AVL {

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

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int height() {
        return height(root);
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

            root = insert(root, value);
        }
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value, 0);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node){
        //Left Heavy case
        if(height(node.left) - height(node.right) > 1){
            //Left-Left case
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }
            //Left-Right case
            else{
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        
        //Right Heavy case
        if(height(node.right) - height(node.left) > 1){
            //Right-Right case
            if(height(node.right.right)-height(node.right.left) > 0){
                return leftRotate(node);
            }
            //Right-Left case
            else{
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left),height(p.right))+1;
        c.height = Math.max(height(c.left),height(c.right))+1;

        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left),height(c.right))+1;
        p.height = Math.max(height(p.left),height(p.right))+1;

        return p;
    }


    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left)
                && balanced(node.right);
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

    public void populate(int[] nums) {
        for (int num : nums) {
            root = insert(root, num);
        }
    }

    // TRAVERSALS
    public void preOrder() {
        System.out.println(preOrder(root));
    }

    private String preOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        result.append(root.value);

        String left = preOrder(root.left);
        String right = preOrder(root.right);

        if (!left.isEmpty()) {
            result.append("->").append(left);
        }

        if (!right.isEmpty()) {
            result.append("->").append(right);
        }

        return result.toString();
    }

    public void inOrder() {
        System.out.println(inOrder(root));
    }

    private String inOrder(Node root) {
        if (root == null) {
            return "";
        }

        String left = inOrder(root.left);
        String right = inOrder(root.right);

        StringBuilder result = new StringBuilder();

        if (!left.isEmpty()) {
            result.append(left).append("->");
        }

        result.append(root.value);

        if (!right.isEmpty()) {
            result.append("->").append(right);
        }

        return result.toString();
    }

    public void postOrder() {
        System.out.println(postOrder(root));
    }

    private String postOrder(Node root) {
        if (root == null) {
            return "";
        }

        String left = postOrder(root.left);
        String right = postOrder(root.right);

        StringBuilder result = new StringBuilder();

        if (!left.isEmpty()) {
            result.append(left).append("->");
        }

        if (!right.isEmpty()) {
            result.append(right).append("->");
        }

        result.append(root.value);

        return result.toString();
    }
}