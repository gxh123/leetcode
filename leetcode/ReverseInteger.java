public class ReverseInteger {

    public static void main(String[] args) {
        System.out.print(reverse(-1234567899));
    }

    public static int reverse(int x) {
        // boolean isNegtive = false;
        // if (x < 0)
        // isNegtive = true;
        // int xx = Math.abs(x);
        // long result = 0;
        // while (xx > 0) {
        // result = result * 10 + xx % 10;
        // xx = xx / 10;
        // if (result > Integer.MAX_VALUE)
        // result = Integer.MAX_VALUE;
        // }
        // if (isNegtive)
        // result = result * (-1);
        // return (int) result;

        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE)
                result = 0;
            else if (result < Integer.MIN_VALUE)
                result = 0;
        }
        return (int) result;
    }

}
