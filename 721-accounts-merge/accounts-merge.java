class Solution {
    class Node{
    String name;
    String mail;
    Node parent;
    Node(){}
    Node(String name, String mail){
        this.name=name;
        this.mail=mail;
    };
    public String toString(){
        return "{"+mail+", "+name+", "+(parent!=null?parent.mail:"_")+"}";
    }
}

public List<List<String>> accountsMerge(List<List<String>> accounts) {
    
    Map<String,Node> map = new HashMap<>();
    
    for(int i=0;i<accounts.size();i++){
        List<String> accs = accounts.get(i);
        String name = accs.get(0);
        for(int j=1;j<accs.size();j++){
            if(!map.containsKey(accs.get(j))){
                map.put(accs.get(j),new Node(name,accs.get(j)));
                map.get(accs.get(j)).parent=map.get(accs.get(j));
            }
        }
        Node parent = map.get(accs.get(1));
        for(int j=2;j<accs.size();j++){
            merge(parent,map.get(accs.get(j)));
        }
    }
    //System.out.println(map);
    for(Node node:map.values()){
        find(node);
    }
    
    Map<Node,PriorityQueue<String>> map2 = new HashMap<>();
    for(Node node:map.values()){
        PriorityQueue<String> pq = map2.getOrDefault(node.parent,new PriorityQueue<>());
        pq.offer(node.mail);
        map2.put(node.parent,pq);
    }
    List<List<String>> sol = new ArrayList<>();
    for(Map.Entry<Node,PriorityQueue<String>> entry: map2.entrySet()){
        List<String> l = new ArrayList<>();
        l.add(entry.getKey().name);
        while(!entry.getValue().isEmpty()){
            l.add(entry.getValue().poll());
        }
        sol.add(l);
    }
    return sol;
}

public boolean merge(Node a,Node b){
    Node u = find(a);
    Node v = find(b);
    if(u==v){
        return false;
    }else{
        u.parent=v.parent;
        return true;
    }
}

public Node find(Node a){
    if(a.parent==a){
        return a;
    }else{
        a.parent=find(a.parent);
        return a.parent;
    }
}
}