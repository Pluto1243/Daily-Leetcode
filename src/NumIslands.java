/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        // 记录岛屿
        int res = 0;
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (grid[i][j] == '1') {
                    checkIsland(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void checkIsland(char[][] grid, int i, int j) {
        // 越界了
        if (!isArea(grid, i, j)) {
            return;
        }
        // 是海洋或者已经标记过了
        if (grid[i][j] != '1' ) {
            return;
        }
        grid[i][j] = '2';
        // 继续搜索相邻的板块
        checkIsland(grid, i - 1, j);
        checkIsland(grid, i + 1, j);
        checkIsland(grid, i, j - 1);
        checkIsland(grid, i, j + 1);
    }

    public Boolean isArea(char[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}
