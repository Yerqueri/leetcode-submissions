class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> value = getValMap();
        int sum =0;
        int max =0;
        for(int i=s.length()-1;i>=0;i--){
            if(value.get(s.charAt(i))<max){
                sum-=value.get(s.charAt(i));
            }else{
                sum+=value.get(s.charAt(i));
            }
            max = Math.max(max,value.get(s.charAt(i)));
        }
        return sum;
    }

    private Map<Character,Integer> getValMap(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}