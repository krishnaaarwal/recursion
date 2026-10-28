package Trees;

public class Segment {

    public static void main(String[] args) {
        int[] arr = {6,7,-2,-8,4,9};
        Segment segment = new Segment(arr);
        segment.display();
        System.out.println(segment.query(2,6));
    }

    private class Node{
        private int data;
        private int start;
        private int end;
        private Node left;
        private Node right;

        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }

        public Node(int data,int start,int end,Node left,Node right){
            this.data = data;
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public Segment(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    public void insert(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr, int s, int e) {
        if(s == e){
            Node leaf = new Node(s,e);
            leaf.data = arr[s];
            return leaf;
        }

        Node node = new Node(s,e);
        int mid = s + (e-s)/2;

        node.left = constructTree(arr,s,mid);
        node.right = constructTree(arr,mid+1,e);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(root, "", true);
    }

    private void display(Node node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }

        System.out.println(
                prefix
                        + (isTail ? "└── " : "├── ")
                        + node.data
                        + " [" + node.start + ", " + node.end + "]"
        );

        if (node.left != null || node.right != null) {
            if (node.right != null) {
                display(
                        node.right,
                        prefix + (isTail ? "    " : "│   "),
                        node.left == null
                );
            }

            if (node.left != null) {
                display(
                        node.left,
                        prefix + (isTail ? "    " : "│   "),
                        true
                );
            }
        }
    }

    public int query(int qsi,int qei){
        return this.query(root,qsi,qei);
    }

    private int query(Node node,int qsi,int qei){
        if(node.start >= qsi && node.end <= qei){
            //completely inside
            return node.data;
        }else if((node.start > qei) || (node.end < qsi)){
            return 0;
        }else{
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }
}
