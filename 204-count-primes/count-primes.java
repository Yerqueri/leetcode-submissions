class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int[] arr = new int[n];
        arr[2]=1;
        int count =1;
        for(int i=3;i<arr.length;i++){
            if(arr[i]==0 && (i&1) == 1){
                count++;
                int j =1;
                while(i*j<arr.length){
                    arr[i*j] = 1;
                    j++;
                }
            }
        }
        return count;
    }
}