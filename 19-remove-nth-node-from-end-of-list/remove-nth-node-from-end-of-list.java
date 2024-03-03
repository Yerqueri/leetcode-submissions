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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp =head;
        int count =0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        n=count-n;
        if(n==0){
            return head.next;
        }else{
            temp = head;
            while(n>1){
                temp = temp.next;
                n--;
            }
            //System.out.println(temp.val);
            if(temp!=null && temp.next!=null){
                temp.next = temp.next.next;
            }
            return head;
        }
        
    }
}