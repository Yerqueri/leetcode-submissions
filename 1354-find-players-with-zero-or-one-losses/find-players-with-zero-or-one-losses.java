class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] arr: matches){
            int f1= map.getOrDefault(arr[0], 0);
            map.put(arr[0],f1);
            int f2 = map.getOrDefault(arr[1],0);
            f2++;
            map.put(arr[1],f2);
        }
        TreeMap<Integer,List<Integer>> map2 = new TreeMap<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            List<Integer> list = map2.getOrDefault(entry.getValue(), new ArrayList<>());
            list.add(entry.getKey());
            map2.put(entry.getValue(),list);
        }
        List<List<Integer>> sol = new ArrayList<>();
        sol.add(map2.getOrDefault(0, new ArrayList<>()));
        Collections.sort(sol.get(0));
        sol.add(map2.getOrDefault(1, new ArrayList<>()));
        Collections.sort(sol.get(1));

        return sol;

    }
}