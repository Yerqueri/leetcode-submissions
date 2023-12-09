class Solution {

    Map<Integer,Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        List<Integer> l = new ArrayList<>();
        for(int i=lo;i<=hi;i++){
            l.add(i);
        }

        Collections.sort(l,(b,a)->{
            int val = Integer.compare(power(a),power(b));
            if(val==0){
                return Integer.compare(a,b);
            }
            return val;
        });
        Collections.reverse(l);

        return l.get(k-1);
    }

    private int power(int n){
        if(n==1){
            return 0;
        }else if(map.containsKey(n)){
            return map.get(n);
        }else{
            if((n&1)==0){
                map.put(n, 1+power(n>>1));
            }else{
                map.put(n, 1+power(3*n+1));
            }
            return map.get(n);
        }
    }
}