class Solution {
    public int minimumLength(String s) {
        if(s.charAt(0)!=s.charAt(s.length()-1) || s.length()==1){
            return s.length();
        }else{
            char c = s.charAt(0);
            int i=0;
            while(i<s.length() && s.charAt(i)==c){
                i++;
            }
            int j = s.length()-1;
            while(j>=0 && s.charAt(j)==c){
                j--;
            }
            if(i>j){
                return 0;
            }else{
                return minimumLength(s.substring(i,j+1));
            }
        }
    }
}