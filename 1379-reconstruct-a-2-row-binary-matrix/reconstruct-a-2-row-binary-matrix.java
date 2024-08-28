class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int[] remaining = fillTwosAndZeroes(l1,l2,colsum,upper,lower);
        upper = remaining[0];
        lower = remaining[1];
        int count = remaining[2];
        System.out.println(l1+" "+upper);
        System.out.println(l2+" "+lower);
        System.out.println(count);
        if(count != lower+upper || lower<0 || upper<0){
            return new ArrayList<>();
        }else{
            construct2(l1,l2,upper);
        }
        System.out.println(l1);
        System.out.println(l2);
        return List.of(l1,l2);
    }

    private void construct2(List<Integer> l1, List<Integer> l2, int upper) {
        for(int i=0;i<l1.size();i++){
            if(l1.get(i).equals(-1)){
                if(upper>0){
                    l1.set(i,1);
                    upper--;
                }else{
                    l1.set(i,0);
                }
            }
        }
        constructSecondBasedOnFirst(l1, l2);
    }

    private void constructSecondBasedOnFirst(List<Integer> l1, List<Integer> l2) {
        for(int i = 0; i< l2.size(); i++){
            if(l2.get(i).equals(-1)){
                if(l1.get(i).equals(0)){
                    l2.set(i,1);
                }else{
                    l2.set(i,0);
                }
            }
        }
    }
    
    private int[] fillTwosAndZeroes(List<Integer> l1, List<Integer> l2, int[] colsum, int upper, int lower) {
        int count = 0;
        for(int i=0;i<colsum.length;i++){
            if(colsum[i]==2){
                l1.add(1);
                l2.add(1);
                upper--;
                lower--;
            }else if(colsum[i]==0){
                l1.add(0);
                l2.add(0);
            }else{
                l1.add(-1);
                l2.add(-1);
                count++;
            }
        }
        return new int[]{upper,lower,count};
    }
}