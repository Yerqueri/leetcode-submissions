class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++){
                min = Math.min(min,matrix[i][j]);
            }
            set.add(min);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int i=0;i<matrix[0].length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                max = Math.max(max,matrix[j][i]);
            }
            set2.add(max);
        }
        set.retainAll(set2);
        return new ArrayList<>(set);
    }
}