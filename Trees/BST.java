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

        return node;
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
}