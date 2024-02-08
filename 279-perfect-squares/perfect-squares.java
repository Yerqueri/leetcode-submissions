class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int numSquares(int n) {
        if(n<=0){
            return 0;
        }else if(map.containsKey(n)){
            return map.get(n);
        }
        int min = Integer.MAX_VALUE;
        for(int i=(int)Math.sqrt(n);i>0;i--){
            if(n-(i*i)>=0){
                min = Math.min(min,numSquares(n-(i*i)));
            }
        }
        map.put(n,1+min);
        return 1+min;
    }
}