class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int half = n/2;
        int count =0;
        for(int i=0;i<n;i++){
            boolean flag = isVowel(s.charAt(i));
            //System.out.println(index);
            if(flag){
                if(i<half){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return count==0;
    }

    private boolean isVowel(char c){
        if(c=='a' || c=='A' || c=='e' || c== 'E' || c=='i' || c== 'I' || c=='o' || c== 'O' || c=='u' || c== 'U'){
            return true;
        }
        return false;
    }
}