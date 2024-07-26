class Trie {

    class Node{
        char c;
        Map<Character,Node> map;
        boolean isTerminal;
        Node(char c){
            this.c =c;
            map = new HashMap<>();
            isTerminal = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node('*');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            Node node = curr.map.get(word.charAt(i));
            if(node == null){
                node = new Node(word.charAt(i));
                curr.map.put(word.charAt(i),node);
            }
            curr = node;
        }
        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            Node node = curr.map.get(word.charAt(i));
            if(node == null){
                return false;
            }
            curr = node;
        }
        return curr.isTerminal;
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            Node node = curr.map.get(word.charAt(i));
            if(node == null){
                return false;
            }
            curr = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */