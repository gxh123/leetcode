public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.print(arrangeCoins(0));
    }

    public static int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        for (int i = 1;; i++) {
            if (n - i <= i)
                return i;
            n = n - i;
        }
    }

}
