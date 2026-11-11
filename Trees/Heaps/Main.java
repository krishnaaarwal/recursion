package Trees.Heaps;

public class Main {
    public static void main(String[] args) throws Exception{
        Heaps<Integer> heaps = new Heaps<>();
        heaps.insert(22);
        heaps.insert(67);
        heaps.insert(69);

        System.out.println(heaps.removeFromRoot());

        heaps.insert(12);

        System.out.println(heaps.removeFromRoot());
        System.out.println(heaps.removeFromRoot());
    }
}
