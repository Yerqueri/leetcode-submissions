import java.util.*;

class Solution {

    int[] original;
    int[] copy;
    Random random;

    public Solution(int[] nums) {
        original = nums;
        copy = Arrays.copyOf(original, original.length);
        random = new Random();
    }
    
    public int[] reset() {
        copy = Arrays.copyOf(original, original.length);
        return copy;
    }
    
    public int[] shuffle() {
        int max = copy.length;
        for(int i=0;i<copy.length;i++){
            int swapIndex = i + random.nextInt(max-i);
            swap(i,swapIndex,copy);
        }
        return copy;
    }

    private void swap(int i, int j, int[] arr){
        int x = arr[i];
        arr[i]=arr[j];
        arr[j]=x;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */