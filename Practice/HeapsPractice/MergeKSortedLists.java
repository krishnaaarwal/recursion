package Practice.HeapsPractice;


import java.util.PriorityQueue;

public class MergeKSortedLists {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.val,b.val)
        );

        for (ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }

        while(!pq.isEmpty()){
            ListNode polled = pq.poll();

            tail.next = polled;
            tail = polled;

            if(polled.next != null){
                pq.offer(polled.next);
            }

        }
        return dummy.next;
    }
}