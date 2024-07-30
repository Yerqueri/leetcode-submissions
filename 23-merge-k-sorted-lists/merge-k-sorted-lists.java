/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode node: lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode head = new ListNode(-1_000_000);
        ListNode temp = head;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            ListNode next = node.next;
            node.next = null;
            if(next!=null){
                pq.offer(next);
            }
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }
}