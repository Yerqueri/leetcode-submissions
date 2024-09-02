class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long[] ck = new long[chalk.length];
        ck[0]=chalk[0];
        for(int i=1;i<chalk.length;i++){
            ck[i]=chalk[i]+ck[i-1];
        }
        k = (int) ((k*1l)%ck[ck.length-1]);
        for(int i=0;i<ck.length;i++){
            if(ck[i]>k){
                return i;
            }
        }
        return -1;
    }
}