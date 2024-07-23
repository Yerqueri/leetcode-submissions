class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            int f = map.getOrDefault(i,0);
            map.put(i,f+1);
        }
        List<Map.Entry<Integer,Integer>> l = new ArrayList<>(map.entrySet());
        l.sort((a,b)->{
            if(Integer.compare(a.getValue(),b.getValue())==0){
                return Integer.compare(b.getKey(),a.getKey());
            }else{
                return Integer.compare(a.getValue(),b.getValue());
            }
        });
        int j =0;
        for(int i=0;i<l.size();i++){
            for(int k=0;k<l.get(i).getValue();k++){
                nums[j]=l.get(i).getKey();
                j++;
            }
        }
        return nums;
    }
}