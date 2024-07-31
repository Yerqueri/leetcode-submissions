class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<Integer>> map = new HashMap<>();
        Map<String,Integer> fmap = new HashMap<>();
        for(String word:strings){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<word.length();i++){
                char c = word.charAt((i+word.length())%word.length());
                char d = word.charAt((i+word.length()-1)%word.length());
                l.add(((int)c - (int)d +26)%26);
            }
            map.put(word,l);
            int f = fmap.getOrDefault(word,0);
            fmap.put(word,f+1);
        }
        Map<List<Integer>,List<String>> map2 = new HashMap<>();
        for(Map.Entry<String,List<Integer>> entry: map.entrySet()){
            List<String> l = map2.getOrDefault(entry.getValue(),new ArrayList<>());
            for(int i=0;i<fmap.get(entry.getKey());i++){
                l.add(entry.getKey());
            }
            map2.put(entry.getValue(),l);
        }
        return new ArrayList(map2.values());
    }
}