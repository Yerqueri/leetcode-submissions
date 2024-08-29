class Solution {
    Map<int[],int[]> map;
    public int removeStones(int[][] stones) {
        map = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],stones[i]);
        }
        for(int i=0;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    dsu(stones[i],stones[j]);
                }
            }
        }
        // Path compression;
        for(int i=0;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    dsu(stones[i],stones[j]);
                }
            }
        }
        //System.out.println(map);
        Set<int[]> set = new HashSet<>(map.values());
        return stones.length-set.size();
    }

    private void dsu(int[] a, int[] b){
        int[] pa = findParent(a);
        int[] pb = findParent(b);
        map.put(pb, pa);
    }

    private int[] findParent(int[] a){
        if(map.get(a)==a){
            return a;
        }else{
            int[] pa = findParent(map.get(a));
            map.put(a,pa);
            return pa;
        }
    }
}