class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        int inf = 100_000;
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i==j){
                    graph[i][j]=0;
                }else{
                    graph[i][j] = inf;
                }
            }
        }
        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][k]!=inf 
                        && graph[k][j]!=inf 
                        && graph[i][j]>graph[i][k]+graph[k][j]){
                            graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(graph[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min = count;
                city = i;
            }
            //System.out.println(Arrays.toString(graph[i]));
        }

        return city;
    }
}