class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==0){
            return List.of(0);
        }
        Map<Integer, Set<Integer>> graph = getGraph(edges);
        // System.out.println("start: " +edges[0][0]);
        Node extreme1 = getExtremeNode(new Node(edges[0][0], 0), graph);
        resetAllGlobalVariables(extreme1);
        // System.out.println("extreme1: " +extreme1);
        Node extreme2 = getExtremeNode(extreme1, graph);
        // System.out.println("extreme2: " +extreme2);
        Set<Integer> mids1 = getMidKeys(getMids(extreme2));
        resetAllGlobalVariables(extreme2);
        Node extreme3 = getExtremeNode(extreme2, graph);
        // System.out.println("extreme3: " +extreme3);
        // System.out.println("visited: " + visited);
        Set<Integer> mids2 = getMidKeys(getMids(extreme3));
        // System.out.println("mids1: "+ mids1);
        // System.out.println("mids2: "+ mids2);
        Set<Integer> mids = consolidateMids(mids1,mids2);
        // System.out.println("mids: "+ mids);
        return new ArrayList<>(mids);
    }

    private Set<Integer> consolidateMids(Set<Integer> mids, Set<Integer> mids2) {
        Set<Integer> consolidatedSet = new HashSet<>();
        for(int i:mids){
            if(mids2.contains(i)){
                consolidatedSet.add(i);
            }
        }
        return consolidatedSet;
    }

    private Set<Integer> getMidKeys(Set<Integer> mids) {
        Set<Integer> sol = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: visited.entrySet()){
            if(mids.contains(entry.getValue())){
                sol.add(entry.getKey());
            }
        }
        return sol;
    }

    private static Set<Integer> getMids(Node extreme2) {
        int maxDiatance = extreme2.distance;
        Set<Integer> mids = new HashSet<>();
        if((maxDiatance & 1)==1){
            mids.add(maxDiatance/2);
            mids.add((maxDiatance/2)+1);
        }else{
            mids.add(maxDiatance/2);
        }
        return mids;
    }

    private void resetAllGlobalVariables(Node extreme1) {
        extreme1.distance=0;
        //System.out.println(extreme1);
        farthestNode = null;
        visited.clear();
    }

    private Node getExtremeNode(Node edges, Map<Integer, Set<Integer>> graph) {
        findFarthestNode(edges, graph);
        Node extreme1 = farthestNode;
        return extreme1;
    }

    private static Map<Integer, Set<Integer>> getGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i< edges.length; i++){
            graph.put(edges[i][0],new HashSet<>());
            graph.put(edges[i][1],new HashSet<>());
        }
        for(int i = 0; i< edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }

    private Node farthestNode = null;
    private Map<Integer,Integer> visited = new HashMap<>();


    private void findFarthestNode(Node node, Map<Integer,Set<Integer>> graph){
        if(visited.containsKey(node.val)){
            return;
        }else{
            if(farthestNode==null || farthestNode.distance < node.distance){
                farthestNode=node;
            }
            visited.put(node.val,node.distance);
            for(int i: graph.get(node.val)){
                findFarthestNode(new Node(i,node.distance+1), graph);
            }
        }
    }
}

class Node{
    int val;
    int distance;
    public Node(){}
    public Node(int val, int distance){
        this.val = val;
        this.distance = distance;
    }
    public String toString(){
        return "{"+this.val+","+this.distance+"}";
    }
}