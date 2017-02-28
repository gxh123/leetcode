import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.print(isPalindrome(Integer.MAX_VALUE));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int sum = 0; // //这里不需要用long，如果溢出就让它溢出，照样比较
        int xx = x;
        while (x > 0) {
            sum = sum * 10 + x % 10;
            // if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            // return false;
            // }
            x = x / 10;
        }
        if (xx == sum)
            return true;
        else
            return false;
    }

    // //使用了额外的空间，不符合题目要求
    public static boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;

        List<Integer> digits = new ArrayList<>();
        while (x != 0) {
            digits.add(x % 10);
            x = x / 10;
        }
        int size = digits.size();
        // 3个数，i到1
        // 4个数，i到2
        // ...
        for (int i = 0; i <= size / 2; i++) {
            if (digits.get(i) != digits.get(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
