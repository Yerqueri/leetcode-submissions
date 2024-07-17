class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int pown = (int)Math.pow(2,n);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<pown;i++){
            list.add(generate(nums,i,n));
        }
        return list;
    }

    private List<Integer> generate(int[] arr, int curr, int n){
        List<Integer> list = new ArrayList<>();
        int mask =1;
        for(int i=0;i<n;i++){
            if((curr & mask<<i)!=0){
                list.add(arr[i]);
            }
        }
        return list;
    }
}
