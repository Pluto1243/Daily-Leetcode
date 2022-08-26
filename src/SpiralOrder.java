import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int count = maxRow * maxCol;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int minRow = 0;
        int minCol = 0;
        while (count > 0) {
            // →
            for(; j < maxCol && count > 0; j++) {
                list.add(matrix[i][j]);
                count--;
            }
            minRow++;
            i++;
            j--;
            // ↓
            for (; i < maxRow && count > 0; i++) {
                list.add(matrix[i][j]);
                count--;
            }
            maxCol--;
            i--;
            j--;
            // ←
            for (; j >= minCol && count > 0; j--) {
                list.add(matrix[i][j]);
                count--;
            }
            maxRow--;
            j++;
            i--;
            // ↑
            for (; i >= minRow && count > 0; i--) {
                list.add(matrix[i][j]);
                count--;
            }
            minCol++;
            j++;
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
