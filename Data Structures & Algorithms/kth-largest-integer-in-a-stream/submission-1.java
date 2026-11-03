class KthLargest {
    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            this.pq.offer(num);
            if (this.pq.size() > k) {
                this.pq.poll();
            }
        }
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if (this.pq.size() > k) {
            this.pq.poll();
        } 
        return this.pq.peek();
    }
}
