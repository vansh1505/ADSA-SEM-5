class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = 0;
        int min = (int) 1e9;

        for(int n : nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int ans = max - min - 2 * k;
        return ans > 0 ? ans : 0;
    }
}