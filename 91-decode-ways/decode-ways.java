class Solution {
    Map<Integer,Integer> dp;
    public int numDecodings(String s) {
        dp = new HashMap<>();
        return count(s,0);
    }

    public int count(String s, int i){
        if(dp.containsKey(i)){
            return dp.get(i);
        }else if(i==s.length()){
            return 1;
        }else if(s.charAt(i)=='0'){
            return 0;
        }else if(i==s.length()-1){
            return 1;
        }else{
            int ans = count(s,i+1);
            if(Integer.parseInt(s.substring(i,i+2))<=26){
                ans+= count(s,i+2);
            }
            dp.put(i,ans);
            return ans;
        }
    }
}