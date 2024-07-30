class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s: words){
            int f = map.getOrDefault(s,0);
            map.put(s,f+1);
        }
        List<Map.Entry<String,Integer>> l = new ArrayList<>(map.entrySet());
        l.sort((a,b)->{
            int val = Integer.compare(b.getValue(),a.getValue());
            if(val==0){
                return a.getKey().compareTo(b.getKey());
            }else{
                return val;
            }
        });
        List<String> sol = new ArrayList<>();
        for(int i=0;i<k;i++){
            sol.add(l.get(i).getKey());
        }
        return sol;
    }
}