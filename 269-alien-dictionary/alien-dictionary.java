class Solution {
    Stack<Character> st = new Stack<>();
    public String alienOrder(String[] words) {
        List<char[]> edges = new ArrayList<>();
        Map<Character,Node> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                map.put(c, new Node(c));
            }
        }
        for(int i=1;i<words.length;i++){
            int j =0;
            while(j<words[i-1].length() && j<words[i].length() && words[i-1].charAt(j)==words[i].charAt(j)){
                j++;
            }
            if(j<words[i-1].length() && j<words[i].length()){
                edges.add(new char[]{words[i-1].charAt(j),words[i].charAt(j)});
            }else if(j<words[i-1].length() && j>=words[i].length()){
                return "";
            }
        }
        if(edges.isEmpty()){
            String word = "";
            for(String w: words){
                if(w.length()>word.length()){
                    word = w;
                }
            }
            Set<Character> set = new HashSet<>();
            StringBuilder str = new StringBuilder();
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(!set.contains(c)){
                    str.append(c);
                    set.add(c);
                }
            }
            return str.toString();
        }
        for(char[] edge:edges){
            Node src = map.get(edge[0]);
            Node dest = map.get(edge[1]);
            src.children.add(dest);
        }

        for(Node node: map.values()){
            if(node.color==-1 && checkCycle(node)){
                return "";
            }
        }
        StringBuilder str = new StringBuilder();
        Set<Character> set = new HashSet<>();
        while(!st.isEmpty()){
            char c = st.pop();
            if(!set.contains(c)){
                str.append(c);
                set.add(c);
            }
        }
        return str.toString();
    }

    private boolean checkCycle(Node node){
        if(node.color == 0){
            return true;
        }else if(node.color==1){
            return false;
        }else if(node.children.isEmpty()){
            node.color = 1;
            st.push(node.c);
            return false;
        }else{
            node.color = 0;
            for(Node child: node.children){
                if(checkCycle(child)){
                    return true;
                }
            }
            node.color =1;
            st.push(node.c);
            return false;
        }
    }

    class Node{
        char c;
        int color;
        List<Node> children;
        Node(char c){
            this.c = c;
            this.color =-1;
            this.children = new ArrayList<>();
        }
        public String toString(){
            return c+" "+color;
        }
    }
}