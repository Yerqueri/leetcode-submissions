class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            dsu(edge[0],edge[1]);
        }
        for(int[] edge: edges){
            dsu(edge[0],edge[1]);
        }
        System.out.println(Arrays.toString(parent));
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(parent[i]);
        }
        return set.size();
    }

    private void dsu(int a, int b){
        int A = findParent(a);
        int B = findParent(b);
        parent[A] = B;
    }

    private int findParent(int a){
        if(parent[a]==a){
            return a;
        }else{
            parent[a] = findParent(parent[a]);
            return parent[a];
        }
    }
}