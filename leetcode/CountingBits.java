import java.util.HashMap;
import java.util.Map;

public class CountingBits {

    public static void main(String[] args) {
        countBits(5);
    }

    public static int[] countBits2(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        int t = 3;
        for (int i = 0; i < 4 * 8 - 2; i++) {
            map.put(t, -1 * i);
            t = (t << 1) + 1;
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                int difference = i ^ (i - 1);
                result[i] = result[i - 1] + map.get(difference);
            }
        }
        return result;
    }

    // 神奇的做法，感觉智商被脸压了...
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        // Divide number in 2 parts:
        // <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
        // <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }

}
