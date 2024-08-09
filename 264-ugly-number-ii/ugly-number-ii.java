public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 1, factor3 = 1, factor5 = 1;
        for(int i=0;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min){
                factor2 = 2*ugly[index2];
                index2++;
            }
            if(factor3 == min){
                factor3 = 3*ugly[index3];
                index3++;
            }
            if(factor5 == min){
                factor5 = 5*ugly[index5];
                index5++;
            }
        }
        return ugly[n-1];
    }
}