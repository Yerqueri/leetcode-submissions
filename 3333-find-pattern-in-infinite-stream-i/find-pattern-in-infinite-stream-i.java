/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */
class Solution {
    public int findPattern(InfiniteStream stream, int[] pattern) {
        long p = 0;
        for(int i:pattern){
            p = p<<1;
            p+=i;
        }
        int n = pattern.length;
        long s = 0;
        long mask = 0;
        for(int i=0;i<n;i++){
            s=s<<1;
            s+=stream.next();
            mask = mask<<1;
            mask = mask | 1;
        }
        int index =0;
        while(s!=p){
            s = s<<1;
            s = s & mask;
            s += stream.next();
            index++;
        }
        return index;
    }
}