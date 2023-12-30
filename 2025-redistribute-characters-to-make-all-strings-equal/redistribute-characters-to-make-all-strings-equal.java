class Solution {
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        for(String s: words){
            char[] carr = s.toCharArray();
            for(int i=0;i<carr.length;i++){
                arr[(int)carr[i]-(int)'a']++;
            }
        }
        int n = words.length;
        for(int i=0;i<26;i++){
            if(arr[i]%n!=0){
                return false;
            }
        }
        return true;
    }
}