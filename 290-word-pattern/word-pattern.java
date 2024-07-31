class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if(s1.length!=pattern.length()){
            return false;
        }
        Map<String,Character> map = new HashMap<>();
        Map<Character,String> map2 = new HashMap<>();
        for(int i=0;i<s1.length;i++){
            if(map.containsKey(s1[i]) && map.get(s1[i])!=pattern.charAt(i)){
                return false;
            }
            if(map2.containsKey(pattern.charAt(i)) && !map2.get(pattern.charAt(i)).equals(s1[i])){
                return false;
            }
            map.put(s1[i],pattern.charAt(i));
            map2.put(pattern.charAt(i), s1[i]);
        }

        StringBuilder s2 = new StringBuilder();
        for(int i=0;i<s1.length;i++){
            s2.append(map.get(s1[i]));
        }
        return s2.toString().equals(pattern);

    }
}