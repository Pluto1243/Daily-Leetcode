public class DpStudy {

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return n;
        }
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
