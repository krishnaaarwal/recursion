package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.display();

        BST bst = new BST();
        bst.insert(scanner);
        bst.display();
        System.out.println(bst.balanced());
    }
}
