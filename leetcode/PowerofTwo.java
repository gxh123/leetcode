public class PowerofTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2 * 2 * 2 * 2 - 1));
        int n = 10;
        System.out.println(n >> 1);
        n = -10;
        System.out.println(Integer.toHexString(n >> 1));
        System.out.println(Integer.toHexString(n >>> 1));
        System.out.println(n >>> 1);
    }

    public static boolean isPowerOfTwo(int n) {
        int countofBit1 = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                countofBit1++;
            }
            n = n >>> 1;
        }
        return countofBit1 == 1;
    }

}
