/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    int len = i - j + 1;
                    if (maxLen < len) {
                        maxLen = len;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "cccaacc";
        System.out.println(longestPalindrome(s));
    }
}
