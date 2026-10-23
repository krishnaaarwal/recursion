package Trees;

import java.util.Scanner;

public class BinaryTree {

    public BinaryTree(){

    }

    private static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
        }
    }

   private Node root;

    //INSERT
    public void populate(Scanner scanner){
        System.out.println("Enter the Root node: ");
        int val = scanner.nextInt();
        root = new Node(val);

        populate(scanner,root);
    }

    private void populate(Scanner scanner,Node node){
        System.out.println("Do you want to enter Left of "+node.value);
        boolean left = scanner.nextBoolean();

        if(left){
            System.out.println("enter the value Left of "+node.value);
            int val = scanner.nextInt();
            node.left = new Node(val);

            populate(scanner,node.left);
        }

        System.out.println("Do you want to enter Right of "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("enter the value Right of "+node.value);
            int val = scanner.nextInt();
            node.right = new Node(val);

            populate(scanner,node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(Node node,String indent){
        if(node==null){
            return;
        }
        System.out.println(indent + node.value);

        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }

}
