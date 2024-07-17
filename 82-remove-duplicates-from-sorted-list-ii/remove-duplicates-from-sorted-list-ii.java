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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode();
        ListNode head2 = temp;
        int prevVal =Integer.MIN_VALUE;
        while(head!=null){
            if(head.val!=prevVal && (head.next==null || (head.next!=null && head.next.val!=head.val))){
                ListNode temp2 = head;
                prevVal = head.val;
                head = head.next;
                temp2.next = null;
                temp.next = temp2;
                temp = temp.next;
            }else{
                prevVal = head.val;
                head = head.next;
            }
            
        }
        return head2.next; 
    }
}