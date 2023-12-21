class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b)->{
            int val = Integer.compare(a[0],b[0]);
            if(val==0){
                return Integer.compare(b[1],a[1]);
            }
            return val;
        });
        int max =0;
        for(int i=1;i<points.length;i++){
            max = Math.max(points[i][0]-points[i-1][0], max);
        }
        return max;
    }
}