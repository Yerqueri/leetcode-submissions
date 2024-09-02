class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<secret.length();i++){
            int f = map.getOrDefault(secret.charAt(i),0);
            map.put(secret.charAt(i),f+1);
        }
        int bulls = 0;
        int cows = 0;
        for(int i=0;i<guess.length() && i<secret.length();i++){
            if(guess.charAt(i)==secret.charAt(i)){
                bulls++;
                int f = map.get(guess.charAt(i));
                if(f==1){
                    map.remove(guess.charAt(i));
                }else{
                    map.put(guess.charAt(i),f-1);
                }
            }
        }

        for(int i=0;i<guess.length() && i<secret.length();i++){
            if(guess.charAt(i)!=secret.charAt(i) && map.containsKey(guess.charAt(i))){
                cows++;
                int f = map.get(guess.charAt(i));
                if(f==1){
                    map.remove(guess.charAt(i));
                }else{
                    map.put(guess.charAt(i),f-1);
                }
            }
        }
        return bulls+"A"+cows+"B";

    }
}