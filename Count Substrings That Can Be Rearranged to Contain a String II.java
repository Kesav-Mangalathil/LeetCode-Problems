class Solution {
    public long validSubstringCount(String word1, String word2) {
         int n = word1.length();
        int[] need = new int[26];
        int[] have = new int[26];

        int required = 0;
        for (char c : word2.toCharArray()) {
            if (need[c - 'a'] == 0) required++;
            need[c - 'a']++;
        }

        long ans = 0;
        int formed = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int r = word1.charAt(right) - 'a';
            have[r]++;
            if (have[r] == need[r]) {
                formed++;
            }

            while (formed == required) {
                ans += (n - right);

                int l = word1.charAt(left) - 'a';
                have[l]--;
                if (have[l] < need[l]) {
                    formed--;
                }
                left++;
            }
        }
        return ans;
    }
}