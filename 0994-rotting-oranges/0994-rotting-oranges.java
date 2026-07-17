class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>(); // i, j, time
        int fresh = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new int[] {i, j, 0});
                else if(grid[i][j] == 1) fresh++;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int ans = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            ans = Math.max(ans, curr[2]);

            for(int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                int nt = curr[2] + 1;
                
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if(grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    q.offer(new int[] {nx, ny, nt});
                    fresh--;
                }
            }
        }

        return fresh == 0 ? ans : -1;
    }
}