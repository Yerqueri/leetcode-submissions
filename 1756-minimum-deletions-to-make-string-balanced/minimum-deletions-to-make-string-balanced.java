class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                st.push('b');
            }else if(s.charAt(i)=='a'){
                if(!st.isEmpty() && st.peek()=='b'){
                    st.pop();
                    count++;
                }else{
                    st.push('a');
                }
            }
        }
        return count;
    }
}