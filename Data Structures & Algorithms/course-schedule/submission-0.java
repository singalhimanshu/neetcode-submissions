class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // a, b -> a is dependent on b
        int[] indeg = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] preq: prerequisites) {
            int a = preq[0], b = preq[1];
            indeg[a]++;
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        int coursesDone = 0;
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            coursesDone++;
            if (adj.containsKey(u)) {
                for (int v: adj.get(u)) {
                    indeg[v]--;
                    if (indeg[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }
        return coursesDone == numCourses;
    }
}
