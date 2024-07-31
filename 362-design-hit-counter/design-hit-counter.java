import java.util.*;

class HitCounter {

    TreeMap<Integer,Integer> map;

    public HitCounter() {
        map = new TreeMap<>();
    }
    
    public void hit(int timestamp) {
        int f = map.getOrDefault(timestamp,0);
        map.put(timestamp,f+1);
    }
    
    public int getHits(int timestamp) {
        SortedMap<Integer,Integer> submap  = map.subMap(timestamp-300+1,timestamp+1);
        return submap.values().stream().mapToInt(i->i).sum();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */