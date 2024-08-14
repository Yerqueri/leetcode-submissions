class Solution {
    public String intToRoman(int num) {
        int[] numbers = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sol = new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            if(num>=numbers[i]){
                sol.append(roman[i]);
                num-=numbers[i];
                i--;
            }
        }
        return sol.toString();
    }
}