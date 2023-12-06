class Solution {
    public int totalMoney(int n) {
        int count =0;
        int start =0;
        for(int i=0;i<n;i++){
            start++;
            for(int j=0;j<7 && i<n;j++,i++){
                count+=start+j;
            }
            i--;
        }
        return count;
    }
}