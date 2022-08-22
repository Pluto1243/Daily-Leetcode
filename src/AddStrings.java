import java.util.Stack;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * 
 *
 * 
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        StringBuilder s = new StringBuilder("");
        for(char c: num1.toCharArray()) {
            s1.push(c - '0');
        }
        for(char c: num2.toCharArray()) {
            s2.push(c - '0');
        }
        boolean up = false;
        while (!s1.empty() || !s2.empty()) {
            int n1 = 0;
            int n2 = 0;
            if (!s1.empty()) {
                n1 = s1.pop();
            }
            if (!s2.empty()) {
                n2 = s2.pop();
            }
            int sum = n1 + n2;
            if (up) {
                sum = sum + 1;
            }
            if (sum / 10 > 0) {
                s = s.insert(0, sum % 10);
                up = true;
            } else {
                s = s.insert(0, sum);
                up = false;
            }

        }
        if (up == true) {
            s.insert(0, 1);
        }
        return s.length() > 0 ? s.toString() : "0";
    }

    public static void main(String[] args) {
        String s1 = "498828660196";
        String s2 = "840477629533";
//        String s1 = "11";
//        String s2 = "123";
        System.out.println(addStrings(s1, s2));
    }
}
