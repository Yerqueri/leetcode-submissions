class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int count =0;
        int max =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                max = Math.max(max,count);
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    st.pop();
                }
                st.pop();
                count--;
            }else{
                st.push(s.charAt(i));
            }
        }
        return max;
    }
}