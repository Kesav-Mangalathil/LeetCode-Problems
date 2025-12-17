class Solution {
    public long distributeCandies(int n, int limit) {
         long ans = 0;

        for (int a = 0; a <= Math.min(n, limit); a++) {
            int remaining = n - a;

            int minB = Math.max(0, remaining - limit);
            int maxB = Math.min(limit, remaining);

            if (minB <= maxB) {
                ans += (maxB - minB + 1);
            }
        }
        return ans;
    }
}