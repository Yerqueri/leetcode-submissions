class WordDictionary {
    
    class Node{
        Map<Character,Node> map;
        boolean isTerminal;
        char c;
        Node(char c){
            this.map = new HashMap<>();
            this.isTerminal = false;
            this.c = c;
        }
    }

    Node root;

    public WordDictionary() {
        root=new Node('*');
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            Node node = curr.map.get(c);
            if(node==null){
                curr.map.put(c,new Node(c));
            }
            curr = curr.map.get(c);
        }
        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
        //System.out.println(word);
        return search(root,0,word);
    }

    private boolean search(Node node, int i, String word){
        if(node==null){
            return false;
        }if(i==word.length()){
            return node.isTerminal;
        }else{
            if(word.charAt(i)=='.'){
                boolean flag = false;
                for(Node child: node.map.values()){
                    flag = flag || search(child,i+1,word);
                }
                return flag;
            }else{
                return search(node.map.get(word.charAt(i)),i+1,word);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */