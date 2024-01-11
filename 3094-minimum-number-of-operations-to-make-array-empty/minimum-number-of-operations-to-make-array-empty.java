class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count  =0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int currCount = find(entry.getValue());
            if(currCount==Integer.MAX_VALUE){
                return -1;
            }
            count+=currCount;
        }
        return count;
    }

    Map<Integer,Integer> dp = new HashMap<>();

    private int find(int val){
        if(val==0){
            return 0;
        }else if(dp.containsKey(val)){
            return dp.get(val);
        }else if(val-2 <0 && val-3<0){
            dp.put(val, Integer.MAX_VALUE);
            //System.out.println(dp);
            return dp.get(val);
        }else{
            dp.put(val,1+Math.min(find(val-2),find(val-3)));
            //System.out.println(dp);
            return dp.get(val);
        }
    }
}