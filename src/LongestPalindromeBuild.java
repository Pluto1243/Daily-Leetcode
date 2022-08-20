import java.util.HashSet;

/**
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 *
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输入:1
 * 
 *
 * 提示:
 *
 * 1 <= s.length <= 2000
 * s只由小写 和/或 大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestPalindromeBuild {

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (Character c: chars
             ) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        return set.size() == 0?count * 2: count * 2 + 1;
    }

}
