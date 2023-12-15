class Solution {
    Map<String,Integer> map = new HashMap<>();
    Map<Integer,String> map2 = new HashMap<>();
    public String destCity(List<List<String>> paths) {
        int i=0;
        for(List<String> path: paths){
            map.put(path.get(0),i);
            map.put(path.get(1),i+1);
            i+=2;
        }
        int curr=0;
        String currVal = "";
        for(String key: map.keySet()){
            map2.put(map.get(key), key);
        }

        for(List<String> path: paths){
            int a = parent(path.get(0));
            int b = parent(path.get(1));
            map.put(path.get(0),b);
        }

        for(List<String> path: paths){
            int a = parent(path.get(0));
            int b = parent(path.get(1));
            map.put(path.get(0),b);
        }

        // System.out.println(map);
        // System.out.println(map2);
        return map2.get(map.get(paths.get(0).get(0)));
    }

    private int parent(String key){
        if(key == map2.get(map.get(key))){
            return map.get(key);
        }else{
            return parent(map2.get(map.get(key)));
        }
    }
}