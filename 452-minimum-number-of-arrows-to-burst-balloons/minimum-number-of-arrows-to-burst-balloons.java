class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });
        int curr =0;
        int count =0;
        while(curr<points.length){
            count++;
            int index = curr+1;
            while(index<points.length && points[index][0]<=points[curr][1] && points[index][1]>= points[curr][1]){
                index++;
            }
            curr=index;
        }
        return count;
    }
}