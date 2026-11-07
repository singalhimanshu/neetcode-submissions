class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[n + 1];
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (var entry: freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = n; i >= 0; i--) {
            for (int val: buckets[i]) {
                res[j++] = val;
                if (j == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
