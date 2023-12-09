class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(cost, cost.length-1), solve(cost, cost.length-2));
    }

    private int solve(int[] cost, int index){
        if(index==0 || index ==1){
            return cost[index];
        }else if(map.containsKey(index)){
            return map.get(index);
        }else{
            int val = cost[index] + Math.min(solve(cost, index-1), solve(cost,index-2));
            map.put(index,val);
            return val;
        }
    }
}