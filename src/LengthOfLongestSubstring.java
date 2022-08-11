import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangjie
 * @date 22:56 2022年08月07日
 **/
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for (end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                // 更新start之后， start~end不存在重复字符串
                start = Math.max(map.get(c), start);
            }
            // 对比最长的字符串和该不重复字符串的长度
            max = Math.max(max, end - start + 1);
            map.put(c, end + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
