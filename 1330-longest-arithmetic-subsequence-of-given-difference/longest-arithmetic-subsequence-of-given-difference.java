class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i: arr){
            if(map.containsKey(i-difference)){
                map.put(i,map.get(i-difference)+1);
            }else{
                map.put(i,1);
            }
            max = Math.max(map.get(i),max);
        }
        return max;
    }
}