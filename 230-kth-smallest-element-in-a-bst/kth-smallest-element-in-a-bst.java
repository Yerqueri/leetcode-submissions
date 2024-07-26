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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        if(k-1<list.size()){
            return list.get(k-1);
        }else{
            return 0;
        }
    }

    private void traverse(TreeNode root, List<Integer> l){
        if(root==null){
            return;
        }else{
            traverse(root.left,l);
            l.add(root.val);
            traverse(root.right,l);
        }
    }
}