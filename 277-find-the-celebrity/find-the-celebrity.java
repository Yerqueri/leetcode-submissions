/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    int[] parent;
    public int findCelebrity(int n) {
        int celeb =0;
        for(int i=1;i<n;i++){
            if(knows(celeb,i)){
                celeb=i;
            }
        }
        if(isCeleb(celeb,n)){
            return celeb;
        }
        return -1; 
    }
    
    private boolean isCeleb(int celeb, int n){
        for(int i=0;i<n;i++){
            if(celeb ==i){
                continue;
            }else{
                if(knows(celeb,i) || !knows(i,celeb)){
                    return false;
                }
            }
        }
        return true;
    }
}