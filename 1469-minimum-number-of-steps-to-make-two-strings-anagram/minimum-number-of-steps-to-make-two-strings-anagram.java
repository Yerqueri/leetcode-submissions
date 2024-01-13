class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)-1);
        }
        int count =0;
        System.out.println(map);
        for(Integer val: map.values()){
            count+=Math.abs(val);
        }
        return count/2;
    }
}