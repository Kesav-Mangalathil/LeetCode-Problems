import java.util.*;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();

        // value -> rows that contain this value
        Map<Integer, List<Integer>> valueToRows = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int v : grid.get(i)) {
                valueToRows
                    .computeIfAbsent(v, k -> new ArrayList<>())
                    .add(i);
            }
        }

        // Process values from largest to smallest
        List<Integer> values = new ArrayList<>(valueToRows.keySet());
        values.sort(Collections.reverseOrder());

        int maxMask = 1 << n;
        int[] dp = new int[maxMask];

        for (int val : values) {
            int[] next = dp.clone();
            for (int mask = 0; mask < maxMask; mask++) {
                for (int row : valueToRows.get(val)) {
                    if ((mask & (1 << row)) == 0) {
                        int newMask = mask | (1 << row);
                        next[newMask] = Math.max(
                            next[newMask],
                            dp[mask] + val
                        );
                    }
                }
            }
            dp = next;
        }

        int ans = 0;
        for (int v : dp) ans = Math.max(ans, v);
        return ans;
    }
}