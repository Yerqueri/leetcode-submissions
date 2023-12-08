class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> l = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<A.length && j<B.length){
            if(A[i][0]<=B[j][0] && B[j][0]<=A[i][1]){
                l.add(new int[]{B[j][0],Math.min(A[i][1],B[j][1])});
            }else if(B[j][0]<=A[i][0] && A[i][0]<=B[j][1]){
                l.add(new int[]{A[i][0],Math.min(B[j][1],A[i][1])});
            }
            
            if(A[i][1]<=B[j][1]){
                i++;
            }else{
                j++;
            }
        }
        int[][] sol = new int[l.size()][2];
        for( i=0;i<l.size();i++){
            sol[i]=l.get(i);
        }
        return sol;
    }
}