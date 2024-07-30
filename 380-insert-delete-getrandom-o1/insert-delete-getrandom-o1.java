class RandomizedSet {

    Map<Integer,Integer> map;
    List<Integer> l;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        l = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            l.add(val);
            map.put(val,l.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int temp = l.get(l.size()-1);
            l.set(index,temp);
            l.remove(l.size()-1);
            map.put(temp,index);
            map.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int index = random.nextInt(l.size());
        return l.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */