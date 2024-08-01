class Solution {
    public int countSeniors(String[] details) {
        int count =0;
        for(String s: details){
            if(s.charAt(11)>='6'){
                if(s.charAt(11)=='6' && s.charAt(12)=='0'){
                    continue;
                }else{
                    count++;
                }
            }
        }
        return count;
    }
}