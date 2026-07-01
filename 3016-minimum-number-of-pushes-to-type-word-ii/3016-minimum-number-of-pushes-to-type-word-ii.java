class Solution {
    public int minimumPushes(String word) {

        int[] frequency = new int[26];

        for (char ch : word.toCharArray()) {
            frequency[ch - 'a']++;
        }

        Arrays.sort(frequency);

        int answer = 0;
        int position = 0;

        for (int i = 25; i >= 0; i--) {

            if (frequency[i] == 0)
                break;

            answer += frequency[i] * ((position / 8) + 1);
            position++;
        }

        return answer;
    }
}