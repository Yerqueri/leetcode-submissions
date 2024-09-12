class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int count = words.length;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(!set.contains(words[i].charAt(j))){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}