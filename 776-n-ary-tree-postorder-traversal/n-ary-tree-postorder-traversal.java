/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> l = new ArrayList<>();
        postorder(l,root);
        return l;
    }
    
    private void postorder(List<Integer> list, Node node){
        if(node!=null){
            if(node.children!=null){
                for(Node child: node.children){
                    postorder(list,child);
                }
            }
            list.add(node.val);
        }
    }
}