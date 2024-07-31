class Solution {
    public void reverseWords(char[] s) {
        swap(0,s.length-1,s);
        int prev = 0;
        for(int i=0;i<s.length;i++){
            char c = s[i];
            if(s[i]==' '){
                swap(prev,i-1,s);
                prev = i+1;
            }
        }
        swap(prev, s.length-1,s);
    }

    private void swap(int i, int j, char[] s){
        if(i<0 || j>=s.length || j<i){
            return;
        }
        while(i<j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}