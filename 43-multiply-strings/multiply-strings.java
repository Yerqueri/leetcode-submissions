class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0'){
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] n1 = new int[l1];
        int[] n2 = new int[l2];
        int[] sol = new int[l1+l2+1];
        for(int i=l1-1;i>=0;i--){
            n1[i]=(int)num1.charAt(i)-(int)'0';
        }
        for(int i=l2-1;i>=0;i--){
            n2[i]=(int)num2.charAt(i)-(int)'0';
        }
        for(int i=l2-1, j=0;i>=0 && j<sol.length;i--,j++){
            sum(sol,j,multiply2(n1,n2[i]));
            //System.out.println(Arrays.toString(sol));
        }
        StringBuilder sb = new StringBuilder();
        boolean nonZeroFound = false;
        for(int i=0;i<sol.length;i++){
            if(sol[i]!=0){
                nonZeroFound = true;
            }
            if(nonZeroFound) {
                sb.append(sol[i]);
            }
        }
        //System.out.println(sb);
        return sb.toString();
    }

    private int[] multiply2(int[] n1, int num) {
        int[] sol = new int[n1.length+1];
        int carry =0;
        for(int i=sol.length-1,j=n1.length-1;i>=0 && j>=0;i--,j-- ){
            int val = (n1[j]*num)+carry;
            sol[i]=val%10;
            carry = val/10;
        }
        sol[0]=carry;
        //System.out.println("multiply: "+ Arrays.toString(n1)+" * "+num +" ==> "+Arrays.toString(sol));
        return sol;
    }

    private void sum(int[] sol, int i, int[] val) {
        int carry =0;
        for(int j=sol.length-i-1, k = val.length-1;j>=0 && k>=0;j--,k--){
            int x = sol[j]+val[k]+carry;
            if(x>=10){
                sol[j]=x-10;
                carry =1;
            }else{
                sol[j]=x;
                carry=0;
            }
        }
        int k = sol.length-i-1-val.length;
        while(carry!=0 && k>0){
            int x = sol[k]+carry;
            if(x>=10){
                sol[k]=x-10;
                carry =1;
            }else{
                sol[k]=x;
                carry=0;
            }
            k--;
        }
    }
}