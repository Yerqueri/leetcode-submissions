class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int[] a = new int[]{Integer.MAX_VALUE,-1};
        int[] b = new int[]{Integer.MAX_VALUE,-1};
        int[] c = new int[]{Integer.MIN_VALUE,1};
        int[] d = new int[]{Integer.MIN_VALUE,1};
        for(int i=0;i<arrays.size();i++){
            int n = arrays.get(i).size();
            int l = arrays.get(i).get(0);
            int r = arrays.get(i).get(n-1);
            if(l<=a[0] && l<=b[0]){
                b=a;
                a=new int[]{l,i};
            }else if(l<=b[0]){
                b=new int[]{l,i};
            }
            if(r>=c[0] && r>=d[0]){
                d=c;
                c=new int[]{r,i};
            }else if(r>=d[0]){
                d=new int[]{r,i};
            }
        }
        if(a[1]!=c[1]){
            return c[0]-a[0];
        }else{
            return Math.max(d[0]-a[0],c[0]-b[0]);
        }
    }
}