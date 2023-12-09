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

class Node{
    int max;
    int maxSol;

    public String toString(){
        return "{"+max+","+maxSol+"}";
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        return solve(root).maxSol;
    
    }
    
    private Node solve(TreeNode root){
        if(root==null){
            Node node = new Node();
            node.maxSol= -1001;
            return node;
        }else{
            Node left = solve(root.left);
            Node right = solve(root.right);
            int leftMax  = Math.max(0,left.max);
            int rightMax = Math.max(0,right.max);
            int max = Math.max(leftMax,rightMax);
            max+= root.val;
            Node node = new Node();
            node.max = max;
            node.maxSol = Math.max(Math.max(left.maxSol, right.maxSol),leftMax+rightMax+root.val);
            //node.maxSol = Math.max(node.max, node.maxSol);
            //System.out.println(root.val+" "+node);
            return node;
        }
    }
}