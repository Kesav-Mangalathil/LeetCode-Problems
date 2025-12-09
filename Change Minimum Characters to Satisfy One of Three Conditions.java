class Solution {
    public int minCharacters(String a, String b) {
         int[] ca = new int[26];
        int[] cb = new int[26];

        for (char c : a.toCharArray()) ca[c - 'a']++;
        for (char c : b.toCharArray()) cb[c - 'a']++;

        int la = a.length(), lb = b.length();
        int ans = Integer.MAX_VALUE;

        // Condition 3: both consist of only one distinct letter
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, la + lb - ca[i] - cb[i]);
        }

        // Prefix sums
        int[] pa = new int[26];
        int[] pb = new int[26];
        pa[0] = ca[0];
        pb[0] = cb[0];
        for (int i = 1; i < 26; i++) {
            pa[i] = pa[i - 1] + ca[i];
            pb[i] = pb[i - 1] + cb[i];
        }

        // Condition 1 and 2
        for (int i = 0; i < 25; i++) {
            // a < b
            int ops1 = (la - pa[i]) + pb[i];
            // b < a
            int ops2 = (lb - pb[i]) + pa[i];
            ans = Math.min(ans, Math.min(ops1, ops2));
        }

        return ans;
    }
}