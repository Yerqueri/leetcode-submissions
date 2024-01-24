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
    int count =0;
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root, new HashMap<>());
        return count;
    }

    private void traverse(TreeNode root, Map<Integer,Integer> map){
        if(root==null){
            return;
        }else if(root.left==null && root.right==null){
            insert(map,root.val);
            if(isPalindrome(map)){
                count++;
            }
            delete(map,root.val);
        }else{
            insert(map,root.val);
            traverse(root.left,map);
            traverse(root.right, map);
            delete(map,root.val);
        }
    }

    private void insert(Map<Integer,Integer> map, int val){
        int f = map.getOrDefault(val,0);
        map.put(val,f+1);
    }

    private void delete(Map<Integer,Integer> map, int val){
        int f = map.get(val);
        if(f==1){
            map.remove(val);
        }else{
            map.put(val,f-1);
        }
    }

    private boolean isPalindrome(Map<Integer,Integer> map){
        int count =0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
             if((entry.getValue()&1)==1){
                count++;
            }
        }
        System.out.println(map+" "+count);
        return count<=1;
    }
}