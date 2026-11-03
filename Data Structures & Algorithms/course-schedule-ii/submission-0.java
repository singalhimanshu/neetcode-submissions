class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            final int dependency = prereq[1], dependent = prereq[0];
            final List<Integer> neighbrs = graph.getOrDefault(dependency, new ArrayList<>());
            neighbrs.add(dependent);
            graph.put(dependency, neighbrs);
        }
        final int[] indegree = new int[numCourses];
        for (final Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            for (int node : entry.getValue()) {
                indegree[node]++;
            }
        }
        final Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        final int[] result = new int[numCourses];
        int idx = 0;
        int coursesCompleted = 0;
        while (!q.isEmpty()) {
            final int cur = q.poll();
            result[idx++] = cur;
            coursesCompleted++;
            for (int neigh : graph.getOrDefault(cur, new ArrayList<>())) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }
        return coursesCompleted == numCourses ? result : new int[]{};
    }
}
