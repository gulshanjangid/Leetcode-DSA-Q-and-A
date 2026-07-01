class Solution {

    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public long minimumCost(int[] nums, int k, int dist) {

        int n = nums.length;

        Comparator<Pair> cmp = (a, b) -> {
            if (a.value != b.value) return a.value - b.value;
            return a.index - b.index;
        };

        TreeSet<Pair> chosen = new TreeSet<>(cmp);
        TreeSet<Pair> others = new TreeSet<>(cmp);

        long chosenSum = 0;
        long answer = Long.MAX_VALUE;

       
        for (int i = 2; i <= dist + 1 && i < n; i++) {
            Pair p = new Pair(nums[i], i);
            chosen.add(p);
            chosenSum += p.value;

            if (chosen.size() > k - 2) {
                Pair last = chosen.pollLast();
                chosenSum -= last.value;
                others.add(last);
            }
        }

      
        answer = nums[0] + nums[1] + chosenSum;

        for (int firstStart = 2; firstStart <= n - k + 1; firstStart++) {

            int removeIndex = firstStart;
            Pair remove = new Pair(nums[removeIndex], removeIndex);

            if (chosen.remove(remove)) {
                chosenSum -= remove.value;
                if (!others.isEmpty()) {
                    Pair add = others.pollFirst();
                    chosen.add(add);
                    chosenSum += add.value;
                }
            } else {
                others.remove(remove);
            }

            int addIndex = firstStart + dist;
            if (addIndex < n) {
                Pair add = new Pair(nums[addIndex], addIndex);

                if (chosen.size() < k - 2) {
                    chosen.add(add);
                    chosenSum += add.value;
                } else if (!chosen.isEmpty() && cmp.compare(add, chosen.last()) < 0) {
                    Pair last = chosen.pollLast();
                    chosenSum -= last.value;
                    others.add(last);

                    chosen.add(add);
                    chosenSum += add.value;
                } else {
                    others.add(add);
                }
            }

            answer = Math.min(answer, nums[0] + nums[firstStart] + chosenSum);
        }

        return answer;
    }
}