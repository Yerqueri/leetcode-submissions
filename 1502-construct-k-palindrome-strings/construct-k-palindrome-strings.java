class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k){
            return false;
        }
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            arr[(int)c-(int)'a']++;
        }
        int ones =0;
        for(int i=0;i<26;i++){
            ones += arr[i]&1;
        }
        return ones <=k;
    }
}