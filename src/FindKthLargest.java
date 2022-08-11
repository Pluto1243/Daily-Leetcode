import java.util.List;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangjie
 * @date 16:36 2022年08月08日
 **/
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        //3,2,3,1,2,4,5,5,6
        quickSort(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivok = nums[i];
        while(i < j) {
            while(i < j && nums[j] >= pivok) {
                j--;
            }
            if(i < j) {
                nums[i] = nums[j];
            }
            while(i < j && nums[i] <= pivok) {
                i++;
            }
            if(i < j) {
                nums[j] = nums[i];
            }
        }
        // 这时 i下标左边的都比它小， 右边的都比它大
        nums[i] = pivok;
        if (j != nums.length - k) {
            quickSort(nums, left,i-1, k);
            quickSort(nums,i+1, right, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
    }
}
