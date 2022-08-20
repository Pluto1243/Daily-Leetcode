/**
 * 斐波那契数列
 **/
public class Fibonacci {

    static int fibonacci(int num) {
        if (num == 0) {
            return num;
        }
        if (num <= 2) {
            return 1;
        }
        int sum = 0;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= num; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    static int fibonacciRecursion(int num) {
        if (num == 0) {
            return num;
        }
        if (num <= 2) {
            return 1;
        }
        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
        System.out.println(fibonacciRecursion(8));
    }
}
