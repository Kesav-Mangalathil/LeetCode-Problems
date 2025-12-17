class Solution {
    public int countCompleteSubarrays(int[] nums) {
     int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int totalDistinct = set.size();

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, distinct = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) distinct++;

            while (distinct == totalDistinct) {
                ans += (n - right);
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) distinct--;
                left++;
            }
        }
        return ans;   
    }
}