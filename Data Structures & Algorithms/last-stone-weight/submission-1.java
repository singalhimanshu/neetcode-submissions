class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s2, s1));
        for (int stone: stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first == second) continue;
            pq.offer(first - second);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
