class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], d = road[2];
            graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : graph[cur]) {
                ans = Math.min(ans, next[1]);

                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.offer(next[0]);
                }
            }
        }

        return ans;
    }
}