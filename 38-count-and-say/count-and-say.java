class Solution {
    public String countAndSay(int n) {
        String curr = "";
        for(int i=0;i<n;i++){
            curr = count(curr);
        }
        return curr;
    }

    private String count(String s){
        if(s.equals("")){
            return "1";
        }
        StringBuilder sol = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int count =0;
            int j =i;
            while(j<s.length() && s.charAt(i)==s.charAt(j)){
                count++;
                j++;
            }
            sol.append(count);
            sol.append(s.charAt(i));
            i=j;
            i--;
        }
        return sol.toString();
    }
}