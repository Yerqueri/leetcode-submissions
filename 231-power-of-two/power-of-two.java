class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return n==1 ? true : (n&1)==0 && isPowerOfTwo(n/2);
    }
}