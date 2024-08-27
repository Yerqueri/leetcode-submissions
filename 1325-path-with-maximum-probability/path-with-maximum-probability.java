class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] max = new double[n];
        max[start_node] = 1.0;
        for(int i=0;i<n;i++){
            boolean isUpdated = false;
            for(int j=0;j<edges.length;j++){
                double prob = succProb[j];
                int u = edges[j][0];
                int v = edges[j][1];
                if(max[u]*prob>max[v]){
                    max[v] = max[u]*prob;
                    isUpdated = true;
                }
                if(max[v]*prob>max[u]){
                    max[u]=max[v]*prob;
                    isUpdated =true;
                }
            }
            if(!isUpdated){
                break;
            }
        }
        return max[end_node];
    }
}