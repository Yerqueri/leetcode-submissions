class Solution {
    public boolean stoneGame(int[] piles) {
        int start = 0;
        int end = piles.length-1;
        return solve(piles,0,0,start,end);
    }

    private boolean solve(int[] piles,int alice, int bob, int start, int end){
        if(start>end){
            return alice>bob;
        }else{
            return solve(piles,alice+piles[start],bob+piles[end],start+1, end-1) || solve(piles,alice+piles[end],bob+piles[start],start+1,end-1);
        }
    }
}