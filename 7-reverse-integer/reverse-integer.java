class Solution {
    public int reverse(int x) {
        long val = 0;
        int sign = x>0 ?1:-1;
        long y = Math.abs(x);
        while(y!=0){
            val = val*10 + (y%10);
            y = y/10;
        }
        val = val*sign;
        if(val<Integer.MIN_VALUE || val>Integer.MAX_VALUE){
            return 0;
        }
        return (int) val;
    }
}