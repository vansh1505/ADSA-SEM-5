class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;

        for(int k = 0; k < nums.length; k += 2) {
            System.out.println(nums[k] + " " + nums[k+1]);
            ans += Math.min(nums[k], nums[k+1]);
        }

        return ans;
    }
}