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
    Map<TreeNode,Map<Boolean,Integer>> map = new HashMap<>();
    public int rob(TreeNode root) {
        // System.out.println(rob(root,true));
        // System.out.println(rob(root,false));
        int val = Math.max(rob(root,true),rob(root,false));
        // for(Map.Entry<TreeNode,Map<Boolean,Integer>> entry: map.entrySet()){
        //     System.out.println(entry.getKey().val+" "+entry.getValue());
        // }
        return val;
    }

    private int rob(TreeNode root,boolean skip){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root) && map.get(root).containsKey(skip)){
            return map.get(root).get(skip);
        }
        int left1 = rob(root.left, true);
        int left2 = rob(root.left, false);
        int right1 = rob(root.right, true);
        int right2 = rob(root.right, false);
        int a = left1+right1;
        int b = left1+right2;
        int c = left2+right1;
        int d = left2+right2;
        int sol =0;
        if(skip){
            sol = Math.max(a,Math.max(b,Math.max(c,d)));
        }else{
            sol = root.val+a;
        }
        Map<Boolean, Integer> tuple = map.getOrDefault(root, new HashMap<>());
        tuple.put(skip,sol);
        map.put(root, tuple);
        return sol;
    }
}