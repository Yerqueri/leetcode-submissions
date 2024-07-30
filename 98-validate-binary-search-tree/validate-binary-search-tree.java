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
    public boolean isValidBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        populate(root,l);
        long max = Long.MIN_VALUE;
        System.out.println(l);
        for(int i=0;i<l.size();i++){
            if(max>=l.get(i)){
                return false;
            }
            max = Math.max(max,l.get(i));
        }
        return true;
    }

    private void populate(TreeNode node, List<Integer> l){
        if(node==null){
            return;
        }else{
            populate(node.left, l);
            l.add(node.val);
            populate(node.right, l);
        }
    }
}