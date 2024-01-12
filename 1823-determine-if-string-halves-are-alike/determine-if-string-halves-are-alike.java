class Solution {
    public boolean halvesAreAlike(String s) {
        int count0 = 0, count1 = 0;
        String vowel = "aeiouAEIOU";
        for(int i=0; i<s.length()/2; i++){
            if(vowel.indexOf(s.charAt(i)) != -1) {
                ++count0;
            }
        }
        for(int i=s.length()-1; i>=s.length()/2; i--){
            if(vowel.indexOf(s.charAt(i)) != -1) {
                ++count1;
            }
        }
        return count0 == count1;
    }
}