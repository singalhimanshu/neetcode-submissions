class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }
        final PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue())); 
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] topK = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            topK[idx++] = minHeap.poll().getKey(); 
        }
        return topK;
    }
}
