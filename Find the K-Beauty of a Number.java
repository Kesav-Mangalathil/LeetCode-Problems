class Solution {
    public int divisorSubstrings(int num, int k) {
           String s = String.valueOf(num);
        int n = s.length();
        int ans = 0;

        for (int i = 0; i + k <= n; i++) {
            int val = Integer.parseInt(s.substring(i, i + k));
            if (val != 0 && num % val == 0) {
                ans++;
            }
        }
        return ans;
    }
}