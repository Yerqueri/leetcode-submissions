class Solution {
    public int titleToNumber(String columnTitle) {
        int sol =0;
        for(int i=0;i<columnTitle.length();i++){
            sol = sol*26 + (int)columnTitle.charAt(i)-(int)'A'+1;
        }
        return sol;
    }
}