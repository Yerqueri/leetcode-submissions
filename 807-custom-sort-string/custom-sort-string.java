class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        Arrays.fill(arr,27);
        for(int i=0;i<order.length();i++){
            int index = (int)order.charAt(i)-(int)'a';
            arr[index]=i;
        }
        List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        list.sort((a,b)->Integer.compare(arr[(int)a-(int)'a'],arr[(int)b-(int)'a']));
        StringBuilder sb = new StringBuilder();
        for(Character c: list){
            sb.append(c);
        }
        return sb.toString();
    }
}