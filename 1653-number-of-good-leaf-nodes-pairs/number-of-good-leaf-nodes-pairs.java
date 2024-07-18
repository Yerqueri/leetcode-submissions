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
    int distance;
    int totalCount;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        this.totalCount =0;
        traverse(root);
        return totalCount;
    }

    private List<Integer> traverse(TreeNode root){
        if(root.left == null && root.right==null){
            return List.of(1);
        }else{
            List<Integer> left = root.left!=null ? traverse(root.left) : new ArrayList<>();
            List<Integer> right = root.right!=null ? traverse(root.right) : new ArrayList<>();
            int count =0;
            for(int i:left){
                for(int j: right){
                    if(i+j<=distance){
                        count++;
                    }
                }
            }
            List<Integer> accumulated = new ArrayList<>();
            for(int i:left){
                accumulated.add(i+1);
            }
            for(int i:right){
                accumulated.add(i+1);
            }
            this.totalCount+=count;
            return accumulated;
        }
    }
}