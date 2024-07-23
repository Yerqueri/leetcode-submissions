class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            int f = map.getOrDefault(i,0);
            map.put(i,f+1);
        }
        return Arrays.stream(nums).boxed().sorted((a,b)->{
            if(map.get(a).equals(map.get(b))){
                return Integer.compare(b,a);
            }else{
                return Integer.compare(map.get(a),map.get(b));
            }
        }).mapToInt(i->i).toArray();
    }
}