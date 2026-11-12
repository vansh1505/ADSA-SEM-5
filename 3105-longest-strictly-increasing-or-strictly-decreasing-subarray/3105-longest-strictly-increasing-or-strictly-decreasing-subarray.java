class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int l = 1;
        int s = 1;

        for (int i = 1; i < nums.length; i++) {
            // increasing
            if(nums[i-1] < nums[i]){
                l++;
            } else {
                l = 1;
            }

            // decreasing
            if(nums[i-1] > nums[i]){
                s++;
            } else {
                s = 1;
            }

            max = Math.max(max, Math.max(l, s));
        }
        return max;
    }
}