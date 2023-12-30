class Solution {
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        for(String s: words){
            s.chars().forEach(el->{
                arr[el-97]++;
            }); 
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