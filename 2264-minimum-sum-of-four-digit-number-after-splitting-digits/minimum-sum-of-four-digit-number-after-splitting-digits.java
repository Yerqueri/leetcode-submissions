class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int x = 1000;
        for(int i=0;i<4;i++){
            arr[i]=num/x;
            num = num%x;
            x = x/10;
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int min =Integer.MAX_VALUE;
        for(int i=1;i<15;i++){
            int a = 0;
            int b =0;
            for(int j=0;j<4;j++){
                if((i & (1<<j))== (1<<j)){
                    a=a*10+arr[j];
                }else{
                    b=b*10+arr[j];
                }
            }
            min = Math.min(min, a+b);
            //System.out.println(i+" "+a+" "+b);
        }
        return min;
    }
}