class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            char t = 'a';
            if(c=='(' || c== '[' || c=='{'){
                st.push(c);
            }else if(c==')' && !st.isEmpty()){
                t = st.pop();
                if(t!='('){
                    return false;
                }
            }else if(c=='}' && !st.isEmpty()){
                t = st.pop();
                if(t!='{'){
                    return false;
                }
            }else if(c==']' && !st.isEmpty()){
                t = st.pop();
                if(t!='['){
                    return false;
                }
            }else{
                return false;
            }
        }
        return st.isEmpty();
    }
}