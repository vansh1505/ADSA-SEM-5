class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int sum = 0;
            while (n > 0){
                int d = n % 10;
                n /= 10;

                sum += d;
            }

            if(i == sum) return i;
        }
        return -1;
    }
}