class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    bfs(r, c, grid);
                }
            }
        }
        return res;
    }

    private void bfs(int r, int c, char[][] grid) {
        if (!(r < grid.length && c < grid[0].length && r >= 0 && c >= 0 && grid[r][c] == '1')) {
            return;
        }
        grid[r][c] = '0';
        bfs(r + 1, c, grid);
        bfs(r - 1, c, grid);
        bfs(r, c + 1, grid);
        bfs(r, c - 1, grid);
    }
}