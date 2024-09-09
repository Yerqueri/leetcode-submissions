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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(mat[i],-1);
        }
        spiral(0,n-1,0,m-1,head, mat);
        return mat;
    }
    // w x cols;
    // y z rows;
    private void spiral(int w,int x, int y, int z, ListNode head, int[][] mat){
        if(head==null){
            return;
        }
        for(int i=w;i<=x && head!= null;i++){
            mat[y][i] = head.val;
            head=head.next;
        }
        for(int i=y+1;i<=z && head!=null;i++){
            mat[i][x] = head.val;
            head = head.next;
        }
        for(int i=x-1;i>=w && head!=null;i--){
            mat[z][i] = head.val;
            head = head.next;
        }
        for(int i=z-1;i>y && head!=null;i--){
            mat[i][w] = head.val;
            head = head.next;
        }
        spiral(w+1,x-1,y+1,z-1,head,mat);
    }
}