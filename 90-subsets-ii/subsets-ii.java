class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        int pown = (int)Math.pow(2,n);
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        for(int i=0;i<pown;i++){
            list.add(generate(nums,i,n));
        }
        return new ArrayList<>(list);
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