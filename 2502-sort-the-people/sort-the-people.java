class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int[][] arr = new int[heights.length][2];
        for(int i=0;i<heights.length;i++){
            arr[i] = new int[]{heights[i],i};
        }
        Arrays.sort(arr, (a,b)->Integer.compare(b[0],a[0]));
        String[] sol = new String[names.length];
        for(int i=0;i<names.length;i++){
            sol[i]=names[arr[i][1]];
        }
        return sol;
    }
}