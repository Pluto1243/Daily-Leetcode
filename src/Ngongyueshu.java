/**
 * 求N个数的最大公约数
 * @author wangjie
 * @date 23:48 2022年05月12日
 **/
public class Ngongyueshu {
  public static void main(String[] args) {
    int[] arr = {88, 44, 20};
    System.out.println(getCommonDivisor(arr));
  }

  static int getCommonDivisor(int[] arr) {
    int temp = 0;
    int x = arr[0];
    int y = arr[1];
    for (int i = 0; i < arr.length; i++) {
      x = arr[i];
      if (y == 0) {
        y = arr[i - 1];
      }
      while (y != 0) {
        temp = x%y;
        x = y;
        y = temp;
      }
    }
    return x;
  }
}
