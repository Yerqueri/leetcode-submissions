class Solution {
    public int minDeletions(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int f = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),f+1);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(Integer val: map.values()){
            q.offer(val);
        }
        int count =0;
        while(!q.isEmpty()){
            int val = q.poll();
            if(set.contains(val)){
                if(val-1!=0){
                    q.offer(val-1);
                }
                count++;
            }else{
                set.add(val);
            }
        }
        return count;
    }
}