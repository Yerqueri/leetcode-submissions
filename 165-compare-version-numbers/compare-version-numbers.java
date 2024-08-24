class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i =0,j=0;
        while(i<v1.length && j<v2.length){
            Integer a = Integer.parseInt(v1[i]);
            Integer b = Integer.parseInt(v2[j]);
            int val = Integer.compare(a,b);
            if(val==0){
                i++;
                j++;
            }else{
                return val;
            }
        }
        while(i<v1.length){
            Integer a = Integer.parseInt(v1[i]);
            if(a!=0){
                return 1;
            }else{
                i++;
            }
        }
        while(j<v2.length){
            Integer b = Integer.parseInt(v2[j]);
            if(b!=0){
                return -1;
            }else{
                j++;
            }
        }
        return 0;

    }
}