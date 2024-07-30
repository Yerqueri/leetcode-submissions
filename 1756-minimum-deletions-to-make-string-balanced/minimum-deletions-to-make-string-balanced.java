class Solution {
    public int minimumDeletions(String s) {
        int count =0;
        int bcount =0;
        for(char c: s.toCharArray()){
            if(c=='b'){
                bcount++;
            }else if(bcount>0){
                count++;
                bcount--;
            }
        }
        return count;
    }
}