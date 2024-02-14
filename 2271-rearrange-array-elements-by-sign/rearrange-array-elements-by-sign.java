class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> negatives = Arrays.stream(nums).filter(el->el<0).boxed().collect(Collectors.toList());
        List<Integer> positives =  Arrays.stream(nums).filter(el->el>=0).boxed().collect(Collectors.toList());
        int[] sol = new int[nums.length];
        for(int i=0;i<positives.size();i++){
            sol[i*2]=positives.get(i);
            sol[(i*2)+1]=negatives.get(i);
        }
        return sol;
    }
}