class Solution {
    public void sortColors(int[] arr) {
        int curr = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                swap(arr,i,curr);
                curr++;
            }
        }
        curr = arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==2){
                swap(arr,i,curr);
                curr--;
            }
        }
    }

    private void swap(int[] arr, int x, int y){
        int z = arr[x];
        arr[x]=arr[y];
        arr[y]=z;
    }
}
