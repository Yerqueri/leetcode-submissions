class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> entries = map.entrySet().stream().sorted((a,b)-> Integer.compare(b.getValue(),a.getValue())).collect(Collectors.toList());
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: entries){
            for(int i=0;i<entry.getValue();i++){
                str.append(entry.getKey());
            }
        }
        return str.toString();
    }
}