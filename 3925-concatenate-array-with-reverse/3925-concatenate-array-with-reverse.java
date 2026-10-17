class Solution {
    public int[] concatWithReverse(int[] nums) {
        int j = 0;
        int[] res = new int[nums.length*2];
        for(int i = 0; i < nums.length; i++){
            res[j] = nums[i];
            j++;
        }
        for(int i = nums.length - 1; i >= 0; i--){
            res[j] = nums[i];
            j++;
        }
        return res;
    }
}