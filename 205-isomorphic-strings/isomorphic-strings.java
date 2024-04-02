class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = map.getOrDefault(s.charAt(i),null);
            if(c==null){
                map.put(s.charAt(i),t.charAt(i));
            }else if(c!=t.charAt(i)){
                return false;
            }
        }
        map.clear();
        for(int i=0;i<t.length();i++){
            Character c = map.getOrDefault(t.charAt(i),null);
            if(c==null){
                map.put(t.charAt(i),s.charAt(i));
            }else if(c!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}