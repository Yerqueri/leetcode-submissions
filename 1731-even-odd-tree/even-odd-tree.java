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
    Map<Integer,List<Integer>> map;
    public boolean isEvenOddTree(TreeNode root) {
        map = new HashMap<>();
        traverse(root,0);
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            //odd level
            if(isOdd(entry.getKey())){
                for(int i=0;i<entry.getValue().size();i++){
                    if(isOdd(entry.getValue().get(i))){
                        return false;
                    }
                    if(i>0 && entry.getValue().get(i)>=entry.getValue().get(i-1)){
                        return false;
                    }
                }
            }else{
                for(int i=0;i<entry.getValue().size();i++){
                    if(!isOdd(entry.getValue().get(i))){
                        return false;
                    }
                    if(i>0 && entry.getValue().get(i)<=entry.getValue().get(i-1)){
                        return false;
                    }
                }
            }
        }

        return true;
        
    }

    private boolean isOdd(int val){
        return (val&1)==1;
    }

    private void traverse(TreeNode node, int level){
        if(node==null){
            return;
        }else{
            List<Integer> list = map.getOrDefault(level, new ArrayList<>());
            list.add(node.val);
            map.put(level,list);
            traverse(node.left, level+1);
            traverse(node.right, level+1);
        }
    }
}