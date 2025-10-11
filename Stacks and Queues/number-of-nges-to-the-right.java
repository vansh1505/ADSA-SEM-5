class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        // code here
        int[] ans = new int[indices.length];
        
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            int target = arr[idx];
            int count = 0;
            
            for (int j = idx + 1; j < arr.length; j++) {
                if (arr[j] > target) count++;
            }
            
            ans[i] = count;
        }
        
        return ans;
    }
}