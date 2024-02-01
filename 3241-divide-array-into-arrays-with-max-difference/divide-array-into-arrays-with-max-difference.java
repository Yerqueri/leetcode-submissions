class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> l = new ArrayList<>();
        for(int i=0;i<nums.length;i+=3){
            int[] temp = new int[3];
            for(int j=i;j<i+3;j++){
                temp[j-i]=nums[j];
            }
            if(temp[2]-temp[1]>k || temp[2]-temp[0]>k || temp[1]-temp[0]>k){
                return new int[][]{};
            }else{
                l.add(temp);
            }
        }
        int[][] sol = new int[l.size()][3];
        for(int i=0;i<l.size();i++){
            sol[i]=l.get(i);
        }
        return sol;
    }
}