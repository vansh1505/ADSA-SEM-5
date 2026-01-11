class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        int[][] prefix = new int[m][n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '1') sum++;
                else sum = 0;
                prefix[i][j] = sum;
            }
        }
        
        for(int i = 0; i < m; i++){
            ans = Math.max(ans, solve(prefix[i]));
        }
        return ans;
    }

    int solve(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : arr[i];

            while (!st.isEmpty() && h < arr[st.peek()]) {
                int height = arr[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max, height * (right - left - 1));
            }
            st.push(i);
        }
        return max;
    }
}