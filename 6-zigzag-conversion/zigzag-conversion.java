class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder[] arr = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            arr[i]= new StringBuilder();
        }
        int i =0;
        while(i<s.length()){
            for(int j = 0;j<numRows-1 && i<s.length();i++,j++){
                arr[j].append(s.charAt(i));
            }
            for(int j=numRows-1; j>0 && i<s.length();j--,i++){
                arr[j].append(s.charAt(i));
            }
        }
        //System.out.println(Arrays.toString(arr));
        String sol = "";
        for(int j=0;j<arr.length;j++){
            sol+=arr[j].toString();
        }
        return sol;
    }
}