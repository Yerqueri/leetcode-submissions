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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null){
            return head;
        }
        int l =-1;
        ListNode head2 = new ListNode(-1000);
        head2.next = head;
        ListNode temp = head2;
        while(temp!=null){
            temp = temp.next;
            l++;
        }
        k = k%l;
        if(k==0){
            return head;
        }
        temp = head;
        ListNode prev = head2;
        for(int i=0;i<l-k;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        ListNode temp2 = temp;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        temp2.next = head;
        return temp;
    }
}