class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum =0;
        for(int i: rolls){
            sum+=i;
        }
        int expectedSum = mean*(rolls.length+n);
        int remainingSum = expectedSum-sum;
        if(n*6<remainingSum || n>remainingSum){
            return new int[]{};
        }else{
            int[] sol = new int[n];
            for(int i=0;i<sol.length;i++){
                sol[i]=remainingSum/n;
                remainingSum -= sol[i];
                n--;
            }
            return sol;
        }
    }
}