class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;

        int[][] ar = new int[n][2];
        for(int i = 0; i < n; i++){
            ar[i][0] = position[i];
            ar[i][1] = speed[i];
        }

        Arrays.sort(ar, (a, b) -> a[0] - b[0]);

        Stack<Double> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            double time = (double) (target - ar[i][0]) / ar[i][1];
            if (s.isEmpty() || time > s.peek()) {
                s.push(time);
            }
        }

        return s.size();
    }
}