/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return max-1;
    }

    private int calculate(TreeNode node){
        if(node==null){
            return 0;
        }else{
            int left = calculate(node.left);
            int right = calculate(node.right);
            max = Math.max(max, left+right+1);
            return Math.max(left,right)+1;
        }
    }
}