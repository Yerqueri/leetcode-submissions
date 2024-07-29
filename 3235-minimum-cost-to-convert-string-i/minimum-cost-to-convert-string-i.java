class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] mat = new long[26][26];
        long inf = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j){
                    mat[i][j]=0;
                }else{
                    mat[i][j]=inf;
                }
            }
        }
        for(int i=0;i<cost.length;i++){
            mat[(int)original[i]-(int)'a'][(int)changed[i]-(int)'a']=Math.min(mat[(int)original[i]-(int)'a'][(int)changed[i]-(int)'a'],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(mat[i][k]!=inf && mat[k][j]!=inf && mat[i][k]+mat[k][j]<mat[i][j]){
                        mat[i][j]=mat[i][k]+mat[k][j];
                    }
                }
            }
        }
        long sol =0;
        for(int i=0;i<source.length();i++){
            int a = (int)source.charAt(i)-(int)'a';
            int b = (int)target.charAt(i)-(int)'a';
            if(mat[a][b]>=inf){
                return -1;
            }else{
                sol+=mat[a][b];
            }
        }
        return sol;
    }
}