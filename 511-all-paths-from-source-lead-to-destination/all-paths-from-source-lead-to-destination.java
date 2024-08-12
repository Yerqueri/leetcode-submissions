class Solution {
    Map<Integer,Node> graph;

    class Node{
        int val;
        List<Node> children;
        Boolean pathExists;
        Node(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new Node(i));
        }
        for(int[] edge: edges){
            Node src = graph.get(edge[0]);
            Node dest = graph.get(edge[1]);
            src.children.add(dest);
        }
        return dfs(graph.get(source),graph.get(destination));
    }

    private boolean dfs(Node source, Node destination){
        if(source.children.isEmpty()){
            return source==destination;
        }else if(source.pathExists!=null){
            return source.pathExists;
        }else{
            source.pathExists = false;
            boolean possible = true;
            for(Node child: source.children){
                possible = possible & dfs(child,destination);
            }
            source.pathExists=possible;
            return source.pathExists;
        }
    }
}