class Solution {
    public int[] countOfPairs(int n, int x, int y) {

        int[] answer = new int[n];

        for (int start = 1; start <= n; start++) {

            for (int end = 1; end <= n; end++) {

                if (start == end) continue;

                int direct = Math.abs(start - end);

                int path1 = Math.abs(start - x) + 1 + Math.abs(y - end);

                int path2 = Math.abs(start - y) + 1 + Math.abs(x - end);

                int distance = Math.min(direct, Math.min(path1, path2));

                answer[distance - 1]++;
            }
        }

        return answer;
    }
}