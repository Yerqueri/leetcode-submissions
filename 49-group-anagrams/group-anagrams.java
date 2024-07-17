class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            String hash = getHash(s);
            List<String> l = map.getOrDefault(hash,new ArrayList<>());
            l.add(s);
            map.put(hash,l);
        }
        //System.out.println(map);
        List<List<String>> sol = new ArrayList<>();
        for(List<String> s: map.values()){
            sol.add(s);
        }
        return sol;
    }

    private String getHash(String s){
        String[] arr = s.split("");
        Arrays.sort(arr);
        StringBuilder str = new StringBuilder();
        for(String st: arr){
            str.append(st);
        }
        return str.toString();
    }
}