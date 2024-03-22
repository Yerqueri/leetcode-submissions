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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        //System.out.println(mid.val);
        mid.next = null;
        head2 = reverse(head2);
        while(head!=null && head2!=null){
            if(head.val != head2.val){
                return false;
            }else{
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}