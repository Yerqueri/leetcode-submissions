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
    public String tree2str(TreeNode root) {
        return traverse(root, "");
    }

    private String traverse(TreeNode node, String s){
        if(node==null){
            return s;
        }else{
            s = s+=node.val;
            if(node.left!=null || node.right!=null){
                s +="(";
                s =traverse(node.left,s);
                s +=")";
                if(node.right!=null){
                    s +="(";
                    s =traverse(node.right,s);
                    s +=")";
                }
            }
            return s;
        }

    }
}