class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s: arr){
            int f = map.getOrDefault(s,0);
            map.put(s,f+1);
        }
        int count =0;
        for(String s: arr){
            if(map.get(s)==1){
                count++;
            }
            if(count == k){
                return s;
            }
        }
        return "";
    }
}