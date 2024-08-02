class Solution {
    public int minSwaps(int[] data) {
        int count =0;
        for(int i=0;i<data.length;i++){
            count+=data[i];
        }
        int curr =0;
        for(int i=0;i<count;i++){
            curr+=data[i];
        }
        int min = count -curr;
        for(int i=count;i<data.length;i++){
            curr = curr - data[i-count] + data[i];
            min = Math.min(count-curr, min);
        }
        return min;
    }
}