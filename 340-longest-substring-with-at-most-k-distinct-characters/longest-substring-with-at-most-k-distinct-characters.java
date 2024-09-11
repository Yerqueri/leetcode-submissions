class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int max =0;
        int l =0;
        for(int i=0;i<=s.length();i++){
            while(map.size()>k){
                int f = map.get(s.charAt(l));
                if(f==1){
                    map.remove(s.charAt(l));
                }else{
                    map.put(s.charAt(l),f-1);
                }
                l++;
            }
            max = Math.max(i-l,max);
            if(i<s.length()){
                int f = map.getOrDefault(s.charAt(i),0);
                map.put(s.charAt(i),f+1);
            }
        }
        return max;
    }
}