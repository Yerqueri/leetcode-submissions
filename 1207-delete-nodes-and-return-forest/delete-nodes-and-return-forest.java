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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delete = new HashSet<>(); 
        List<TreeNode> list = new ArrayList<>();
        for(int i : to_delete){
            delete.add(i);
        }
        makeForest(root,delete,list);
        if(!delete.contains(root.val)){
            list.add(root);
        }
        return list;
    }

    private void makeForest(TreeNode root, Set<Integer> delete, List<TreeNode> list){
        if(root==null){
            return;
        }else{
            makeForest(root.right, delete, list);
            makeForest(root.left,delete,list);
            if(delete.contains(root.val)){
                if(root.left!=null && !delete.contains(root.left.val)){
                    list.add(root.left);
                }
                if(root.right!=null && !delete.contains(root.right.val)){
                    list.add(root.right);
                }
            }
            if(root.left!=null && delete.contains(root.left.val)){
                root.left = null;
            }
            if(root.right!=null && delete.contains(root.right.val)){
                root.right = null;
            }
        }
    }
}