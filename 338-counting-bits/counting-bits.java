class Solution {
    public int[] countBits(int n) {
        int[] sol = new int[n+1];
        for(int i=0;i<=n;i++){
            int count =0;
            int curr = i;
            for(int j =0;j<32;j++){
                if((curr&1)==1){
                    count++;
                }
                curr=curr>>1;
            }
            sol[i]=count;
        }
        return sol;
    }
}