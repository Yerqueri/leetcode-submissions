class Solution {

    Map<Integer,List<Integer>> map = new HashMap<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            solve(i,nums);
        }
        List<Integer> sol = new ArrayList<>();
        for(List<Integer> l: map.values()){
            if(l.size()>sol.size()){
                sol=l;
            }
        }
        return sol;
    }

    private List<Integer> solve(int i, int[] nums){
        if(map.containsKey(i)){
            return map.get(i);
        }else{
            List<Integer> l  = null;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    List<Integer> temp = solve(j,nums);
                    if(l==null || temp.size()+1>l.size()){
                        l=new ArrayList<>(temp);
                        l.add(nums[i]);
                    }
                }
            }
            if(l==null){
                l=new ArrayList<>();
                l.add(nums[i]);
            }
            map.put(i,l);
            //System.out.println(i+" "+map);
            return l;
        }
    }
}