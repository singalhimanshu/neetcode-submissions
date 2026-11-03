class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) pq.offer(stone);
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (pq.isEmpty()) return x;
            int y = pq.poll();
            if (x == y) continue;
            pq.offer(Math.abs(x - y));
        }
        return 0;
    }
}
