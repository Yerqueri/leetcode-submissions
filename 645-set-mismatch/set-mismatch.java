class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int expectedSum = (n*(n+1))/2;
        int repeated = Arrays.stream(nums)
                .boxed()  // Convert int to Integer for better compatibility with Collectors.groupingBy
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .mapToInt(Map.Entry::getKey)  // Use getKey() to get the repeated element
                .limit(1)
                .sum();
        int missing = expectedSum-sum+repeated;
        return new int[]{repeated,missing};
    }
}