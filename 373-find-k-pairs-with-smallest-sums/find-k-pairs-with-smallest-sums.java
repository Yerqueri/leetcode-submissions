class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();
        pq.add(new int[] { nums1[0] + nums2[0], 0, 0 });
        Set<String> visited = new HashSet<>();
        while (list.size() < k && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            String hash = curr[0]+" "+i+" "+j;
            if (!visited.contains(hash)) {
                visited.add(hash);
                list.add(List.of(nums1[i], nums2[j]));
                if (i + 1 < nums1.length) {
                    int[] next = new int[] { nums1[i + 1] + nums2[j], i + 1, j };
                    pq.offer(next);
                }
                if (j + 1 < nums2.length) {
                    int[] next = new int[] { nums1[i] + nums2[j + 1], i, j + 1 };
                    pq.offer(next);
                }
            }
        }
        return list;
    }
}