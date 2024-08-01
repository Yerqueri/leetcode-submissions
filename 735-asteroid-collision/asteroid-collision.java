class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i:asteroids){
            if(i<0){
                boolean destroyed = false;
                while(!st.isEmpty() && st.peek()>0){
                    if(st.peek()<Math.abs(i)){
                        st.pop();
                    }else if(st.peek()==Math.abs(i)){
                        st.pop();
                        destroyed = true;
                        break;
                    }else{
                        destroyed =true;
                        break;
                    }
                }
                if(!destroyed){
                    st.push(i);
                }
            }else{
                st.push(i);
            }
        }
        int [] sol = new int[st.size()];
        for(int i=sol.length-1;i>=0;i--){
            sol[i]=st.pop();
        }
        return sol;
    }
}