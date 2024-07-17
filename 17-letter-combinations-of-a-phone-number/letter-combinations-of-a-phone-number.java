class Solution {
    Map<Character, List<Character>> map;

    List<String> sol;

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        map = Map.of('1',Collections.emptyList(),
            '2',List.of('a','b','c'),
            '3',List.of('d','e','f'),
            '4',List.of('g','h','i'),
            '5',List.of('j','k','l'),
            '6',List.of('m','n','o'),
            '7',List.of('p','q','r','s'),
            '8',List.of('t','u','v'),
            '9',List.of('w','x','y','z')
        );
        sol = new ArrayList<>();
        solve(digits,0,new StringBuilder());
        return sol;
    }

    private void solve(String digits, int index, StringBuilder temp){
        if(index == digits.length()){
            sol.add(temp.toString());
        }else{
            char d = digits.charAt(index);
            for(char c: map.get(d)){
                temp.append(c);
                solve(digits, index+1, temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

}