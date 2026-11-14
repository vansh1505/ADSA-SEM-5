class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;

        for(int size = l; size <= r; size++){
            int i = 0;
            int j = 0;
            int sum = 0;
            while (j < nums.size()) {
                sum += nums.get(j);

                if (j - i + 1 > size) {
                    sum -= nums.get(i);
                    i++;
                }

                if (j - i + 1 == size && sum > 0) {
                    min = Math.min(min, sum);
                }

                j++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}