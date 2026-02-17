class Solution {
    class Pair{
        int wt;
        int i;
        int j;
        Pair(int wt, int i, int j){
            this.wt = wt;
            this.i = i;
            this.j = j;
        }
    }

    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] grid = new int[m][n];
        for(int[] g : grid) Arrays.fill(g, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(0, 0, 0));
        grid[0][0] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int wt = curr.wt;
            int i = curr.i;
            int j = curr.j;

            for(int k = 0; k < 4; k++){
                int nx = i + dx[k];
                int ny = j + dy[k];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    int absDis = Math.abs(heights[i][j] - heights[nx][ny]);
                    absDis = Math.max(wt, absDis);
                    if(absDis < grid[nx][ny]){
                        grid[nx][ny] = absDis;
                        pq.offer(new Pair(absDis, nx, ny));
                    }
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}