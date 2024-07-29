class Solution {
    Node root = new Node('*');
    Map<Integer,Map<Node,Boolean>> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        for(String word: wordDict){
            insert(word);
        }
        return search(s,root,0);
        //System.out.println(dp);
    }

    private boolean search(String word, Node curr, int index){
        if(index == word.length()){
            return curr.isTerminal;
        }else if(dp.get(index)!=null && dp.get(index).get(curr)!=null){
            return dp.get(index).get(curr);
        }else{
            Node node = curr.children.get(word.charAt(index));
            if(node == null){
                return false;
            }else{
                boolean flag = false;
                if(node.isTerminal){
                    flag = search(word,node,index+1) || search(word,root,index+1);
                }else{
                    flag = search(word,node,index+1);
                }
                Map<Node,Boolean> map = dp.getOrDefault(index,new HashMap<>());
                map.put(curr,flag);
                dp.put(index,map);
                return flag;
            }
        }
    }

    private void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            Node node = curr.children.get(word.charAt(i));
            if(node == null){
                node = new Node(word.charAt(i));
                curr.children.put(word.charAt(i),node);
            }
            curr = node;
        }
        curr.isTerminal = true;
    }

    class Node{
        char c;
        boolean isTerminal;
        Map<Character,Node> children;
        Node(char c){
            this.c=c;
            this.isTerminal = false;
            children = new HashMap<>();
        }
        
        public String toString(){
            return "{"+c+", "+ isTerminal +", "+ children+"}";
        }
    }
}