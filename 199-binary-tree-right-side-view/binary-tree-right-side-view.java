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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        traverse(root, map, 0);
        List<Integer> sol = new ArrayList<>(map.size());
        for(int i: map.keySet()){
            sol.add(i,map.get(i));
        }
        return sol;
    }
    
    private void traverse(TreeNode node, Map<Integer,Integer> map, int level){
        if(node ==null){
            return;
        }else{
            traverse(node.left, map,level+1);
            map.put(level,node.val);
            traverse(node.right, map, level+1);
        }
    } 
}