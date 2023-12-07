class Solution {
    public String largestOddNumber(String s) {
        int i=0;
        while(s.charAt(i)=='0'){
          i++;
        }
        s=s.substring(i,s.length());
        for(i=s.length()-1;i>=0;i--){
          if(((((int)s.charAt(i)-(int)'0')&1)==1)){
            return s.substring(0,i+1);
          }
        }
        return "";
    }
}