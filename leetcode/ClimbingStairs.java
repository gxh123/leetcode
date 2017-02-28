public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.print(climbStairs(44));
    }

    // 直接用递归会超时
    // public static int climbStairs(int n) {
    // if (n == 0 || n == 1)
    // return 1;
    // return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        int f = 0;
        int f1 = 1, f2 = 1;
        for (int i = 2; i <= n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

}
