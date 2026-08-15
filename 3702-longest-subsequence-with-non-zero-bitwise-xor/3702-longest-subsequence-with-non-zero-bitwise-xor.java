class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        for(int i : nums){
            ans ^= i;
        }
        if(ans != 0){
            return nums.length;
        }
        for(int i : nums){
            if(i != 0){
                return nums.length - 1;
            }
        }
        return 0;
    }
}