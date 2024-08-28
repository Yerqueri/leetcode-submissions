class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int twice = 0;
        int sum =0;
        for(int i=0;i<colsum.length;i++){
            if(colsum[i]==2){
                twice++;
            }
            sum+=colsum[i];
        }
        if(lower<twice || upper<twice || sum!=lower+upper){
            return new ArrayList<>();
        }else{
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            for(int i=0;i<colsum.length;i++){
                if(colsum[i]==0){
                    l1.add(0);
                    l2.add(0);
                }else if(colsum[i]==2){
                    l1.add(1);
                    l2.add(1);
                    lower--;
                    upper--;
                    twice--;
                }else if(upper>twice){
                    l1.add(1);
                    l2.add(0);
                    upper--;
                }else{
                    l1.add(0);
                    l2.add(1);
                    lower--;
                }
            }
            return List.of(l1,l2);
        }
    }
}