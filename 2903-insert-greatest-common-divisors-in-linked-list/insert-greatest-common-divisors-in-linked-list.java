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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }else{
            ListNode temp = head.next;
            ListNode temp2  = new ListNode(gcd(head.val,temp.val));
            head.next = temp2;
            temp2.next = insertGreatestCommonDivisors(temp);
            return head;
        }
    }

    private int gcd (int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}