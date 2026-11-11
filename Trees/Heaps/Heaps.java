package Trees.Heaps;

import java.util.ArrayList;

public class Heaps <T extends Comparable<T>>{
    private ArrayList<T> list;

    public Heaps(){
        list = new ArrayList<T>();
    }

    public void insert(T target){
        list.add(target);
        upheap(list.size()-1);
    }

    private void upheap(int index){
        if(index == 0){
            return;
        }
        int parentIndex = parent(index);

        T parent = list.get(parentIndex);
        T child = list.get(index);

        if(parent.compareTo(child) > 0 ){  //Means If parent is greater than child   ( > 0 means left is greater than right and  < 0 left is smaller than right)
            swap(parentIndex,index);

            upheap(parentIndex);
        }
    }

    public T removeFromRoot() throws Exception{
        if (list.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T removed = list.get(0);

        int lastIndex = list.size()-1;
        T last = list.get(lastIndex);

        if(!list.isEmpty()){
            list.set(0,last);
            list.remove(lastIndex);

            downheap(0);
        }

        return removed;
    }

    private void downheap(int index) {
        int left = left(index);
        int right = right(index);
        int minIndex = index;

        if (left < list.size() &&
                list.get(left).compareTo(list.get(minIndex)) < 0) {

            minIndex = left;
        }

        if (right < list.size() &&
                list.get(right).compareTo(list.get(minIndex)) < 0) {

            minIndex = right;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            downheap(minIndex);
        }
    }

    private void swap(int first,int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return index * 2 + 1;
    }
    private int right(int index){
        return index * 2 + 2;
    }
}
