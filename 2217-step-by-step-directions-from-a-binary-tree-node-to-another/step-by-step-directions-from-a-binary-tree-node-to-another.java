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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node = getLCA(root, startValue, destValue);
        StringBuilder sb = new StringBuilder();
        getSourcePath(node,startValue,sb);
        StringBuilder sb2 = new StringBuilder();
        getDestPath(node,destValue,sb2);
        return sb.append(sb2.reverse()).toString();
    }

    private boolean getDestPath(TreeNode node, int val, StringBuilder sb){
        if(node==null){
            return false;
        }else if(node.val == val){
            return true;
        }else{
            boolean left = getDestPath(node.left, val, sb);
            boolean right = getDestPath(node.right, val, sb);
            if(left){
                sb.append("L");
                return left;
            }else if(right){
                sb.append("R");
                return right;
            }else{
                return false;
            }
        }
    }

    private boolean getSourcePath(TreeNode node, int val, StringBuilder sb){
        if(node==null){
            return false;
        }else if(node.val==val){
            return true;
        }else{
            boolean left = getSourcePath(node.left, val,sb);
            boolean right = getSourcePath(node.right, val, sb);
            if(left || right){
                sb.append("U");
                return true;
            }
            return false;
        }
    }

    private TreeNode getLCA(TreeNode root, int startValue, int destValue){
        if(root==null || root.val == startValue || root.val == destValue){
            return root;
        }else{
            TreeNode left = getLCA(root.left, startValue, destValue);
            TreeNode right = getLCA(root.right, startValue, destValue);
            if(left!=null && right!=null){
                return root;
            }else if(left !=null){
                return left;
            }else{
                return right;
            }
        }
    }
}