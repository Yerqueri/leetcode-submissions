import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        boolean flag = false;
        for(int i=1;i<num.length()-1;i++){
            for(int j=i+1;j<num.length();j++){
                String s1 = num.substring(0,i);
                String s2 = num.substring(i,j);
                String s3 = num.substring(j);
                if(isValid(s1) && isValid(s2) && isAdditiveNumber(s1,s2,s3)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String s) {
        return s.equals("0") || s.charAt(0)!='0';
    }

    private boolean isAdditiveNumber(String n1, String n2, String num){
        if(n1.equals("0") && n2.equals("0") && num.equals("0")){
            return true;
        }
        if(n1.equals("0") && n2.equals("0") && num.charAt(0)=='0'){
            return isAdditiveNumber("0","0",num.substring(1));
        }
        if(num.isEmpty() || !isValid(num)){
            return false;
        }
        BigInteger a = new BigInteger(n1);
        BigInteger b = new BigInteger(n2);
        BigInteger c = new BigInteger(num);
        if(a.add(b).equals(c)){
            return true;
        }else{
            String s = a.add(b).toString();
            int i = 0;
            while(i<num.length()  && i<s.length() && s.charAt(i)==num.charAt(i)){
                i++;
            }
            if(i<s.length()){
                return false;
            }else{
                return isAdditiveNumber(n2, s, num.substring(i));
            }
        }
    }
}