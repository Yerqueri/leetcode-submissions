class Solution {
    int totalCount =0;
    public int countVowelStrings(int n) {
        for(int i=0;i<5;i++){
            test(i,0,n-1);
        }
        return totalCount;
    }

    private void test(int curr, int length, int n){
        if(length==n){
            totalCount++;
            return;
        }
        for(int i=curr;i<5;i++){
            test(i,length+1,n);
        }
    }
}