class Solution {
    public String largestPalindromic(String num) {
        if(num.isEmpty()){
            return "0";
        }
        int[] arr = new int[10];
        boolean nonZeroFound = false;
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            int x = (int)c - (int)'0';
            if(x!=0){
                nonZeroFound = true;
            }
            arr[x]++;
        }
        if(!nonZeroFound){
            return "0";
        }
        String sol = calculate(arr);
        while(!sol.equals("0") && !sol.isEmpty() && sol.charAt(0)=='0'){
            sol = sol.substring(1,sol.length()-1);
        }
        return sol;
    }

    private String calculate(int[] arr){
        for(int i=9;i>=0;i--){
            if(arr[i]>=2){
                arr[i]-=2;
                return i+calculate(arr)+i;
            }
        }
        for(int i=9;i>=0;i--){
            if(arr[i]==1){
                return String.valueOf(i);
            }
        }
        return "";
    }
}