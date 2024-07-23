class Solution {
    public int myAtoi(String s) {
        if(s.isEmpty()){
            return 0;
        }
        long val =0;
        int sign = 1;
        int i =0;
        boolean zeroEncountered = false;
        boolean signFound = false;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        while(i<s.length() && s.charAt(i)=='0'){
            i++;
            zeroEncountered = true;
        }
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='-'){
                if(zeroEncountered || signFound || val!=0){
                    break;
                }else{
                    sign =-1;
                    signFound = true;
                    continue;
                }
            }
            if(c=='+'){
                if(zeroEncountered || signFound || val!=0){
                    break;
                }else{
                    sign =1;
                     signFound = true;
                    continue;
                }
            }
            int num = (int)c-(int)'0';
            if(num>=0 && num<=9){
                val = val*10+num;
                if(val*sign > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(val*sign<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        return (int)(val*sign);
    }
}