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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;
        ListNode placeHolder = temp;
        ListNode head2 = new ListNode(Integer.MIN_VALUE);
        ListNode temp2 = head2;
        while(temp!=null && temp.next!=null){
            if(temp.next.val<x){
                ListNode temp3 = temp.next;
                temp.next =temp.next.next;
                temp3.next = null;
                temp2.next = temp3;
                temp2 = temp2.next;
            }else{
                temp=temp.next;
            }
        }
        temp2.next = placeHolder.next;
        return head2.next;
    }
}