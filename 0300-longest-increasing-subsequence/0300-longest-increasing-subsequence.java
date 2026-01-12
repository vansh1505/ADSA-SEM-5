class Solution {
    // LIS ON O(nlog(n))
    public int lengthOfLIS(int[] nums) {
        return solve(nums);
    }

    static int solve(int[] arr){
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int pos = bs(dp, arr[i]);
            if(pos == dp.size()) dp.add(arr[i]);
            else dp.set(pos, arr[i]);
        }
        return dp.size();
    }

    static int bs(ArrayList<Integer> dp, int x) {
        int si = 0, ei = dp.size() - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (dp.get(mid) < x) si = mid + 1;
            else ei = mid - 1;
        }
        return si; 
    }
}