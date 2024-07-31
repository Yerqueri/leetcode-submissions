class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }else if(n<=3 || set.contains(n)){
            return false;
        }else{
            int val =0;
            set.add(n);
            while(n!=0){
                int d = n%10;
                val+=d*d;
                n = n/10;
            }
            return isHappy(val);
        }
    }
}