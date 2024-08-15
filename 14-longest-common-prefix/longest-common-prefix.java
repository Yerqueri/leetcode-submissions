class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++){
            int count =0;
            for(int j=0;j<Math.min(strs[i-1].length(),strs[i].length());j++){
                if(strs[i-1].charAt(j)!=strs[i].charAt(j)){
                    break;
                }else{
                    count++;
                }
            }
            min = Math.min(min,count);
        }
        return strs[0].substring(0,Math.min(min,strs[0].length()));
    }
}