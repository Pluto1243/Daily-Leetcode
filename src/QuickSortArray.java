public class QuickSortArray {

    public static int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] <= temp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = temp;
        sort(nums, left, i-1);
        sort(nums, i+1, right);
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        System.out.println(sortArray(nums));
    }
}
