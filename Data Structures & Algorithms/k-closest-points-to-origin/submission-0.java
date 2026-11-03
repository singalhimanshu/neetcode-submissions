class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[0], p1[0]));
        for (int[] point: points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            int[] curr = {dist, point[0], point[1]};
            pq.offer(curr);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            res[idx][0] = curr[1];
            res[idx][1] = curr[2];
            idx++;
        }
        return res;
    }
}
