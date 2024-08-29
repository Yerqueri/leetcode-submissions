class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for (int i = 1; i <= n; i++) {
            int previousSequenceLength = result.size();
            int mask = 1 << (i - 1);
            for (int j = previousSequenceLength - 1; j >= 0; j--) {
                // System.out.println(Integer.toBinaryString(result.get(j)) +" "+Integer.toBinaryString(mask | result.get(j)));
                result.add(mask | result.get(j));
            }
            // System.out.println();
        }
        return result;
    }
}
