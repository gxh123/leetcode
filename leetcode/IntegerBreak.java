public class IntegerBreak {

    public static void main(String[] args) {
        System.out.print(integerBreak3(50));
        // permutate2(6);
    }

    // dp：状态转移方程：f(k) = max(f(k-1),f(k-2)*2,f(k-3)*3)
    public static int integerBreak3(int n) {
        int[] temp = new int[] { 1, 1, 2, 4, 6, 9 };
        if (n <= 6)
            return temp[n - 1];

        int first = 4, second = 6, third = 9;
        int maxProduct = 1;
        for (int i = 7; i <= n; i++) {
            maxProduct = Math.max(maxProduct, first * 3);
            maxProduct = Math.max(maxProduct, second * 2);
            maxProduct = Math.max(maxProduct, third);

            first = second;
            second = third;
            third = maxProduct;
        }
        return maxProduct;

    }

    public static int integerBreak(int n) {
        if (n <= 2)
            return 1;
        if (n == 3)
            return 2;

        int maxProduct = 1;
        while (n > 4) {
            n = n - 3;
            maxProduct = maxProduct * 3;
        }
        if (n == 4)
            maxProduct = maxProduct * 4;
        else if (n == 3)
            maxProduct = maxProduct * 3;
        else
            maxProduct = maxProduct * 2;
        return maxProduct;
    }

    public static int integerBreak2(int n) {
        if (n <= 2)
            return 1;
        if (n == 3)
            return 2;

        int[] maxProduct = new int[1];
        permutate(maxProduct, 1, 0, n);
        return maxProduct[0];
    }

    public static void permutate(int[] maxProduct, int product, int sum, int n) { // 排列
        if (sum == n) {
            if (maxProduct[0] < product)
                maxProduct[0] = product;
        } else {
            if (n - sum == 4) {
                permutate(maxProduct, product * 4, sum + 4, n);
            } else if (n - sum == 2) {
                permutate(maxProduct, product * 2, sum + 2, n);
            } else {
                permutate(maxProduct, product * 3, sum + 3, n);
            }
        }
    }

    // 输出一个数所有可能的由相加产生的情况，随便写写的
    public static void permutate2(int n) { // 排列
        permutate2("", 0, n);
    }

    public static void permutate2(String done, int sum, int n) { // 排列
        if (sum == n) {
            System.out.println(done);
        } else {
            for (int i = 1; i <= n - sum; i++) {
                String temp = (done == "") ? (done + i) : (done + "+" + i);
                permutate2(temp, sum + i, n);
            }
        }
    }

}
