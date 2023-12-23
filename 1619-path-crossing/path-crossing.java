class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<String>();
        int[] curr = new int[]{0,0};
        char[] arr = path.toCharArray();
        set.add(0+"_"+0);
        for(char c: arr){
            int[] next = move(curr, c);
            //System.out.println(Arrays.toString(curr)+"  "+Arrays.toString(next));
            if(set.contains(next[0]+"_"+next[1])){
                return true;
            }else{
                curr = next;
                set.add(curr[0]+"_"+curr[1]);
            }
        }
        return false;
    }

    private int[] move(int[] curr, char c){
        if(c=='N'){
            return new int[]{curr[0],curr[1]+1};
        }else if(c=='S'){
            return new int[]{curr[0],curr[1]-1};
        }else if(c=='E'){
            return new int[]{curr[0]+1,curr[1]};
        }else{
            return new int[]{curr[0]-1,curr[1]};
        }
    }
}