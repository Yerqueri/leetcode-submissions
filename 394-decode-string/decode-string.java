class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                List<Character> buff = new ArrayList<>();
                while(!st.isEmpty() && st.peek()!='['){
                    buff.add(st.pop());
                }
                st.pop();
                int multiplier = getMultiplier(st);
                System.out.println(multiplier+" "+buff);
                multiply(buff, st, multiplier);
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sol = new StringBuilder();
        while(!st.isEmpty()){
            sol.append(st.pop());
        }
        return sol.reverse().toString();
    }

    private int getDigit(char c){
        return (int)c-(int)'0';
    }

    private boolean isNumeric(char c){
        int val = getDigit(c);
        return val>=0 && val<=9;
    }

    private int getMultiplier(Stack<Character> st){
        int tens =1;
        int val =0;
        while(!st.isEmpty() && isNumeric(st.peek())){
            val = tens*getDigit(st.pop())+val;
            tens*=10;
        }
        return val;
    }

    private void multiply(List<Character> list, Stack<Character> st, int multiplier){
        for(int i=0;i<multiplier;i++){
            for(int j=list.size()-1;j>=0;j--){
                st.push(list.get(j));
            }
        }
    }
}