class Solution {
    enum Color{
        WHITE,GREY,BLACK;
    }
    class Node{
        int val;
        List<Node> children;
        Color color;
        Node(int val){
            this.color = Color.WHITE;
            this.children = new ArrayList<>();
            this.val = val;
        }
    }

    Stack<Node> st;

    public int[] findOrder(int n, int[][] edges) {
        st = new Stack<>();
        Map<Integer,Node> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new Node(i));
        }
        for(int[] edge:edges){
            Node src = map.get(edge[1]);
            Node dest = map.get(edge[0]);
            src.children.add(dest);
        }
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(map.get(i).color==Color.WHITE){
                flag = flag || cycleExists(map.get(i));
            }
        } 
        if(!flag){
            int[] sol = new int[n];
            for(int i=0;i<n;i++){
                sol[i]=st.pop().val;
            }
            return sol;
        }else{
            return new int[]{};
        }
    }

    private boolean cycleExists(Node node){
        if(node.color==Color.GREY){
            return true;
        }else if(node.color == Color.BLACK){
            return false;
        }else if(node.children.isEmpty()){
            node.color = Color.BLACK;
            st.push(node);
            return false;
        }else{
            node.color = Color.GREY;
            for(Node child: node.children){
                if(cycleExists(child)){
                    return true;
                }
            }
            node.color = Color.BLACK;
            st.push(node);
            return false;
        }
    }
}