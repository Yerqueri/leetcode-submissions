class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] A = new int[matrix.length][matrix[0].length];
        for(int i=0;i<A.length;i++){
          for(int j=0;j<A[0].length;j++){
            A[i][j]=matrix[i][j]=='1'?1:0;
          }
        }
        int max = 0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    A[i][j]+=A[i-1][j];
                }
            }
            max = Math.max(max, lroh(A[i]));
        }
        max = Math.max(max, lroh(A[0]));
        return max;
    }

    private int lroh(int[] A){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max =0;
        for(int i=0;i<A.length;i++){
            while(st.peek()!=-1 && A[i]<A[st.peek()]){
                int height = A[st.pop()];
                int width = i-st.peek()-1;
                int area = width*height;
                max = Math.max(max,area);
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int height = A[st.pop()];
            int width = A.length-st.peek()-1;
            int area = width*height;
            max = Math.max(max,area);
        }
        return max;
    }
}