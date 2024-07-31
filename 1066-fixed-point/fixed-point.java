class Solution {
    public int fixedPoint(int[] arr) {
        int l = -1;
        int r = arr.length;
        while(l+1<r){
            int mid = (l+r)>>1;
            if(arr[mid]<mid){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(l+1< arr.length && arr[l+1]==l+1){
            return l+1;
        }
        return -1;
    }
}