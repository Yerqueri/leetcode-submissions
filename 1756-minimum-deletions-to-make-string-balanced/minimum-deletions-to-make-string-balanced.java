class Solution {
    public int minimumDeletions(String s) {
        int count =0;
        int bcount =0;
        for(char c: s.toCharArray()){
            if(c=='b'){
                bcount++;
            }else if(c=='a' && bcount>0){
                bcount--;
                count++;
            }
        }
        return count;
    }
}