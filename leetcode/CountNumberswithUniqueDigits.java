public class CountNumberswithUniqueDigits {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    // Let f(n) = count of number with unique digits of length n.
    // f(1) = 10. (0, 1, 2, 3, ...., 9)
    // f(2) = 9 * 9. Because for each number i, there are 9 numbers that are different from i for j
    // to choose from.
    // f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2,there are
    // 8 numbers that are different from i and j for k to choose from.
    // Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
    // ...
    // f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
    // f(11) = 0 = f(12) = f(13)....
    // any number with length > 10 couldn't be unique digits number.
    // 中文总结：对于两位数来说，首位1-9共9种选择（0不能做首位），第二位可供选择的有9种，所以是9*9 = 81
    // 对于三位数：是在二位数的基础上，第三位每个有8种选择，所以就是f(2)*8
    // 对于四位数：是在三位数的基础上，第四位每个有7种选择，所以就是f(3)*7
    public static int countNumbersWithUniqueDigits(int n) { // 题目实际要的就是f(1)+f(2)+..+f(n)
        int result = 1;
        int f = 81;
        for (int i = 1; i <= n; i++) {
            if (n >= 11)
                return result; // 由于11以后都是0，就直接返回
            if (i == 1)
                result = 10; // f(1) = 10;
            else if (i == 2)
                result = 91; // f(2) = 81;/总共81+10
            else {
                f = f * (10 - (i - 1)); // 总共有0-9 10个数字，选掉了i-1个，还剩10 - (i - 1)
                result = result + f; // +f(i)
            }
        }
        return result;
    }
}
