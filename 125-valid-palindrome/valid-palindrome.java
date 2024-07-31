class Solution {
    public boolean isPalindrome(String s) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((int)c >= (int)'a' && (int)c <= (int)'z'){
                l.add((int)c-(int)'a');
            }else if((int)c >= (int)'A' && (int)c <= (int)'Z'){
                l.add((int)c-(int)'A');
            }else if((int)c >= (int)'0' && (int)c <= (int)'9'){
                l.add((int)c-(int)'A'+100);
            }
        }
        int i =0;
        int j =l.size()-1;
        while(i<j){
            if(l.get(i)!=l.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}