public class NthDigit {

    public static void main(String[] args) {
        int t = 1;
        System.out.println(Integer.MAX_VALUE);
        for (int i = 1; i < 10; i++) {
            System.out.println(9 * i * t + "," + t * 9);
            t = t * 10;
        }
    }

    // public static int findNthDigit(int n) {
    //
    // }

}
