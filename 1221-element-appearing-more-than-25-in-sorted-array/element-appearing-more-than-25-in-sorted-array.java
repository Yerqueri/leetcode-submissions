class Solution {
    public int findSpecialInteger(int[] arr) {
        int count =1;
        int maxCount=1;
        int element = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                count++;
                if(count>maxCount){
                    maxCount=count;
                    element=arr[i];
                }
            }else{
                count=1;
            }
            if(count>arr.length/4){
                return arr[i];
            }
        }
        return element;
    }
}