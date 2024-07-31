class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(Math.abs(l1-l2)>1){
            return false;
        }
        if(l1>l2){
            return isOneEditDistance(t,s);
        }
        int i =0;
        while(i<l1 && i<l2 && s.charAt(i)==t.charAt(i)){
            i++;
        }

        if(i==l1){
            return l1!=l2;
        }
        
        if(l1==l2){
            return s.substring(i+1).equals(t.substring(i+1));
        }else{
            return s.substring(i).equals(t.substring(i+1));
        }
    }
}