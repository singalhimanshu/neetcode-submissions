class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (var entry: freq.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(list, (n1, n2) -> Integer.compare(n2[1], n1[1]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }
}
