public class GuessNumberHigherorLower {

    public static void main(String[] args) {
        System.out.print(guessNumber(10));
    }

    public static int guess(int n) {
        if (n > 6)
            return -1; // 这里是题目的题意不清
        if (n < 6)
            return 1;
        return 0;
    }

    // 题目的题意问题
    public static int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guessResult = guess(mid);
            if (guessResult == 1) {
                low = mid + 1;
            } else if (guessResult == -1) {
                high = mid - 1;
            } else
                return mid;
        }
        return -1;
    }

}
