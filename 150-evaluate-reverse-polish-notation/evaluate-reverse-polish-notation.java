class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Long> st = new Stack<>();
        for(String s : tokens){
            if(isOperator(s)){
                long top = operate(s,st.pop(),st.pop());
                st.push(top);
            }else{
                st.push(Long.valueOf(s));
            }
        }
        return st.pop().intValue();
    }

    boolean isOperator(String s){
        return s.equals("+")
            || s.equals("-")
            || s.equals("*")
            || s.equals("/");
    }

    long operate(String operator, long op1, long op2){
        if(operator.equals("/")){
            return op2/op1;
        }else if(operator.equals("*")){
            return op1*op2;
        }else if(operator.equals("-")){
            return op2-op1;
        }else return op1+op2;
    } 
}