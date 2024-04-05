class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        int diff = (int)'a'-(int)'A';
        for(int i=0;i<s.length();i++){
            int val = (int)s.charAt(i);
            if(val>=(int)('A') && val<=(int)('Z')){
                if(!st.isEmpty() && (int)st.peek()==val+diff){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }else{
                 if(!st.isEmpty() && (int)st.peek()==val-diff){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
            //System.out.println(st);
        }
        StringBuilder sol = new StringBuilder();
        while(!st.isEmpty()){
            sol.append(st.pop());
        }
        return sol.reverse().toString();
    }
}