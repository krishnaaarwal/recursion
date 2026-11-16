package Trees.Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoding {
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data,int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }


        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public HuffmanCoding(String feeder) throws Exception{
        HashMap<Character,Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < feeder.length(); i++) {
            Character c = feeder.charAt(i);

            if(frequencyMap.containsKey(c)) {
                int ov = frequencyMap.get(c);

                frequencyMap.put(c, ov + 1);
            }else {
                frequencyMap.put(c,1);
            }
        }

        Heaps<Node> min = new Heaps<>();

        Set<Map.Entry<Character,Integer>> entrySet = frequencyMap.entrySet();

        for (Map.Entry<Character,Integer> entry : entrySet){
            Node node = new Node(entry.getKey(),entry.getValue());
            min.insert(node);
        }

        while(min.size() != 1){
            Node first = min.removeFromRoot();
            Node second = min.removeFromRoot();

            Node newNode = new Node('\0', first.cost+ second.cost);
            newNode.left = first;
            newNode.right = second;
            min.insert(newNode);
        }

        Node ft = min.removeFromRoot();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.init(ft,"");
    }

    private void init(Node node, String osf) {
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }

        init(node.left,osf+"0");
        init(node.right,osf+"1");
    }

    public String encode(String str){
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            ans.append(encoder.get(str.charAt(i)));
        }

        return ans.toString();
    }

    public String decoder(String str){
        StringBuilder key = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            key.append(encoder.get(str.charAt(i)));

            if(decoder.containsKey(key)){
                ans.append(decoder.get(key));
                key = new StringBuilder("");
            }
        }
        return ans.toString();
    }
}
