class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        char[] ss = s.toCharArray();
        for(int i=0;i<ss.length;i++){
            int x = (int)ss[i]-(int)'a';
            arr[x]++;
        }
        char[] tt = t.toCharArray();
        for(int i=0;i<tt.length;i++){
            int x = (int)tt[i]-(int)'a';
            arr[x]--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}