class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] arr = new int[amount+1];
        Arrays.fill(arr, 1_000_00);
        //Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for(int j =0 ;j<coins.length;j++){
                if(i==coins[j]){
                    arr[i]=1;
                }else if(i-coins[j]>=0){
                    arr[i] = Math.min(arr[i],arr[i-coins[j]]+1);
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
        if(arr[amount]>=1_000_00){
            return -1;
        }else{
            return arr[amount];
        }
    }
}