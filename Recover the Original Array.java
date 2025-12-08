class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length;
        int n = m / 2;

        for (int i = 1; i < m; i++) {
            int diff = nums[i] - nums[0];
            if (diff <= 0 || diff % 2 != 0) continue;

            int k = diff / 2;
            int[] arr = tryBuild(nums, k);
            if (arr != null) return arr;
        }
        return new int[0]; // guaranteed to exist
    }

    private int[] tryBuild(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        int n = nums.length / 2;
        int[] res = new int[n];
        int idx = 0;

        for (int x : nums) {
            if (freq.getOrDefault(x, 0) == 0) continue;

            int y = x + 2 * k;
            if (freq.getOrDefault(y, 0) == 0) return null;

            freq.put(x, freq.get(x) - 1);
            freq.put(y, freq.get(y) - 1);
            res[idx++] = x + k;
        }

        return idx == n ? res : null;
    }
}
