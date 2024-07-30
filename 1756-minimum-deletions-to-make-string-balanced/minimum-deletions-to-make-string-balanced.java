class Solution {
    public int minimumDeletions(String s) {
        int count =0;
        int bcount =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                bcount++;
            }else if(s.charAt(i)=='a'){
                if(bcount>0){
                    bcount--;
                    count++;
                }
            }
        }
        return count;
    }
}