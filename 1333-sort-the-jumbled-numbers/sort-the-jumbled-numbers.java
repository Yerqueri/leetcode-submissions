class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<long[]> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            long curr =0;
            int temp = nums[i];
            long tens = 1;
            if(temp==0){
                curr = mapping[0];
            }else{
                while(temp!=0){
                    int val = temp%10;
                    curr = mapping[val]*tens +curr;
                    temp = temp/10;
                    tens = tens*10;
                }
            }
            list.add(new long[]{nums[i],curr,i});
        }
        //System.out.println(map);
        list.sort((a,b)->{
            if(a[1]==b[1]){
                return Long.compare(a[2],b[2]);
            }else{
                return Long.compare(a[1],b[1]);
            }
        });
        for(int i=0;i<list.size();i++){
            nums[i]=(int)list.get(i)[0];
        }
        return nums;
    }
}