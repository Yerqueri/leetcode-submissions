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

    class Node{
        int min;
        int max;
        int sol;

        Node(){}
        Node(int min,int max, int sol){
            this.min = min;
            this.max = max;
            this.sol = sol;
        }

        public String toString(){
            return "{"+min+","+max+","+sol+"}";
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        return traverse(root).sol;
    }

    public Node traverse(TreeNode root){
        if(root ==null){
            return null;
        }else{
            Node left = traverse(root.left);
            Node right = traverse(root.right);
            Node node = new Node();
            if(left==null && right==null){
                int min = 0;
                int max = 0;
                node.min = root.val;
                node.max = root.val;
                node.sol = 0;
            }else if(left==null){
                int min = right.min;
                int max = right.max;
                node.min = Math.min(root.val,min);
                node.max = Math.max(root.val,max);
                node.sol = Math.max(Math.abs(root.val-min),Math.abs(root.val-max));
                node.sol = Math.max(node.sol,right.sol);
            }else if(right==null){
                int min = left.min;
                int max = left.max;
                node.min = Math.min(root.val,min);
                node.max = Math.max(root.val,max);
                node.sol = Math.max(Math.abs(root.val-min),Math.abs(root.val-max));
                node.sol = Math.max(node.sol,left.sol);
            }else{
                int min = Math.min(left.min,right.min);
                int max = Math.max(left.max,right.max);
                node.min = Math.min(root.val,min);
                node.max = Math.max(root.val,max);
                node.sol = Math.max(Math.abs(root.val-min),Math.abs(root.val-max));
                node.sol = Math.max(node.sol,right.sol);
                node.sol = Math.max(node.sol,left.sol);
            }
            //System.out.println(root.val+"--->"+left+", "+right+", "+node);
            return node;
        }
    }
}