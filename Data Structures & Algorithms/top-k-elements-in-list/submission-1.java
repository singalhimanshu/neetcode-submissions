class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        freqMap.forEach((key, v) -> {
            bucket[v].add(key);
        });
        int[] res = new int[k];
        int resIdx = 0;
        for (int i = bucket.length - 1; i >= 0 && resIdx < k; i--) {
            List<Integer> curBucket = bucket[i];
            for (int num : curBucket) {
                res[resIdx++] = num;
                if (resIdx == k) {
                    break;
                }
            }
        }
        return res;
    }
}
