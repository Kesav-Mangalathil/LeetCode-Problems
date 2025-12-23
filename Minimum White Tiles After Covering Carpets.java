class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[][] dp = new int[n + 1][numCarpets + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = dp[i + 1][0] + (floor.charAt(i) == '1' ? 1 : 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= numCarpets; k++) {
                int notCover = dp[i + 1][k] + (floor.charAt(i) == '1' ? 1 : 0);

               
                int cover = dp[Math.min(n, i + carpetLen)][k - 1];

                dp[i][k] = Math.min(notCover, cover);
            }
        }

        return dp[0][numCarpets];
    }
}
