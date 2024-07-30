/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */
class Solution {

    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        StringBuilder str = new StringBuilder();
        for(int i: pattern){
            str.append(i);
        }
        StringBuilder curr = new StringBuilder();
        String hash = str.toString();
        int index =0;
        while(curr.length()!=hash.length()){
            curr.append(infiniteStream.next());
        }
        while(!curr.toString().equals(hash)){
            index++;
            curr.deleteCharAt(0);
            curr.append(infiniteStream.next());
        }
        return index;
    }
}