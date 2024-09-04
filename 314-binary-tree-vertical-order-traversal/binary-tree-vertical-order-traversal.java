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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        traverse(root,map,0);
        return map.entrySet().stream().sorted((a,b)->a.getKey().compareTo(b.getKey())).map(e->e.getValue()).toList();
    }

    private void traverse(TreeNode root, Map<Integer,List<Integer>> map, int val){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.node==null){
                continue;
            }
            List<Integer> l = map.getOrDefault(p.val,new ArrayList<>());
            l.add(p.node.val);
            map.put(p.val,l);
            q.offer(new Pair(p.node.left,p.val-1));
            q.offer(new Pair(p.node.right,p.val+1));
        }
    }

    class Pair{
        TreeNode  node;
        int val;
        Pair(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
    }
}