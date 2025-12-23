
class Solution {
    private char[] digits;
    private Integer[][][][] dp;

    public int numberOfBalancedIntegers(long low, long high) {
        return count(high) - count(low - 1);
    }

    private int count(long x) {
        if (x < 10) return 0; // must have at least 2 digits
        digits = String.valueOf(x).toCharArray();
        dp = new Integer[digits.length][401][2][digits.length + 1];
        return dfs(0, 200, 1, 0, 0);
    }

    private int dfs(int idx, int diff, int tight, int started, int len) {
        if (idx == digits.length) {
            return (started == 1 && len >= 2 && diff == 200) ? 1 : 0;
        }

        if (dp[idx][diff][tight][len] != null) {
            return dp[idx][diff][tight][len];
        }

        int res = 0;
        int limit = tight == 1 ? digits[idx] - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            int nTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                res += dfs(idx + 1, diff, nTight, 0, 0);
            } else {
                int pos = len + 1; // position starts at 1
                int nDiff = diff + ((pos % 2 == 1) ? d : -d);
                if (nDiff >= 0 && nDiff <= 400) {
                    res += dfs(idx + 1, nDiff, nTight, 1, len + 1);
                }
            }
        }

        return dp[idx][diff][tight][len] = res;
    }
}
