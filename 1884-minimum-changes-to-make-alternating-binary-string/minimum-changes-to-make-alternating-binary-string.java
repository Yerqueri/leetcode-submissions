class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        return Math.min(count(0,true,arr),count(0,false,arr));
    }

    private int count(int index, boolean oneExpected, char[] arr){
        if(index>=arr.length){
            return 0;
        }else if(arr[index]=='1' && oneExpected || arr[index]=='0' && !oneExpected){
            return count(index+1,!oneExpected,arr);
        }else{
            return 1+ count(index+1,!oneExpected,arr);
        }
    }
}