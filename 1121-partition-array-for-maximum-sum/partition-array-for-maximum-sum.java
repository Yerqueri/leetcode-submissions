class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return calculate(0,k,arr);
    }

    private int calculate(int start, int k, int[] arr){
        if(start>=arr.length){
            return 0;
        }else if(map.containsKey(start)){
            return map.get(start);
        }else{
            int max = Integer.MIN_VALUE;
            int maxVal = Integer.MIN_VALUE;
            for(int i=start;i<arr.length && i<start+k;i++){
                maxVal = Math.max(maxVal,arr[i]);
                int lengthFromStart = i-start+1;
                max = Math.max(max,lengthFromStart*maxVal+calculate(i+1,k,arr));
            }
            map.put(start,max);
            return max;
        }
    }

}