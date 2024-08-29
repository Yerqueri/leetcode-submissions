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
    public void flatten(TreeNode root) {
        flatten2(root);
    }

    private TreeNode flatten2(TreeNode root){
        if(root==null){
            return null;
        }else if(root.left==null && root.right==null){
            return root;
        }else{
            TreeNode left = flatten2(root.left);
            TreeNode right = flatten2(root.right);
            if(left==null){
                root.right = right;
            }else{
                TreeNode temp = left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = right;
                root.right = left;
                root.left = null;
            }
            return root;
        }
    }
}