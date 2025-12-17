class Solution {
    public int minCapability(int[] nums, int k) {
         int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int x : nums) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRob(int[] nums, int k, int cap) {
        int count = 0;
        boolean prevRobbed = false;

        for (int x : nums) {
            if (x <= cap && !prevRobbed) {
                count++;
                prevRobbed = true;
            } else {
                prevRobbed = false;
            }
            if (count >= k) return true;
        }
        return false;
    }
}
