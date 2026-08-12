class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0)
                pq.offer(count);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> used = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int count = pq.poll();

                    count--;

                    if (count > 0)
                        used.add(count);
                }
                time++;
                if (pq.isEmpty() && used.isEmpty()) {
                    break;
                }
            }

            for (int count : used) {
                pq.offer(count);
            }
        }

        return time;
    }
}
