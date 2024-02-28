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
    Map<Integer,Integer> map;
    public int findBottomLeftValue(TreeNode root) {
        map = new HashMap<>();
        find(0,root);
        int maxKey = 0;
        for(int i: map.keySet()){
            maxKey = Math.max(maxKey,i);
        }
        return map.get(maxKey);
    }

    private void find(int level, TreeNode root){
        if(root==null){
            return;
        }else{
            find(level+1, root.left);
            if(!map.containsKey(level)){
                map.put(level,root.val);
            }
            find(level+1,root.right);
        }
    }
}