class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        st.push(-1);
        for(int i=0;i<heights.length;i++){
            while(st.peek()!=-1 && heights[i]<=heights[st.peek()]){
                int height = heights[st.pop()];
                int width = i-st.peek()-1;
                max = Math.max(max, height*width);
            }
            st.push(i);
        }
        //System.out.println(st);
        while(st.peek()!=-1){
            int height = heights[st.pop()];
            int width = heights.length-st.peek()-1;
            max = Math.max(max, height*width);
        }
        return max;
    }
}