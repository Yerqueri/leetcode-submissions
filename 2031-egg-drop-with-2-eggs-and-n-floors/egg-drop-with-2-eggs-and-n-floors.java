class Solution {
    public int twoEggDrop(int n) {
        int l = 0;
        int r = n;
        while(l<=r){
            int mid = l+r>>1;
            if((mid*(mid+1))/2>=n){
                r=mid-1;
            }else if((mid*(mid+1))/2<n){
                l=mid+1;
            }
        }
        return r+1;
    }
}