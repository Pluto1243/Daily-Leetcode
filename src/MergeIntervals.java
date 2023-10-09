import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 1 < 2 , 3 > 2, 3 < 6, = [1, 6] 1 < 8, 6 < 8
 * 8 < 15, 10 < 15
 *
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,5],[7,10]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author wangjie
 * @date 18:34 2023年10月09日
 **/
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, (v0, v1) -> v0[0] - v1[0]);
        int idx = -1;
        for (int[] it: intervals
             ) {
            // 当前区间的最大值小于下一区间的最小值，则没有重叠
            if (idx == -1 || res[idx][1] < it[0]) {
                idx++;
                res[idx] = it;
            } else {
                // 否则找到重叠的最大部分
                res[idx][1] = Math.max(res[idx][1], it[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);
    }
}
