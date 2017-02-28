import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {

        for (String s : fizzBuzz(15)) {
            System.out.println(s);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else {
                // list.add(changeIn2String(i));
                list.add(String.valueOf(i));
            }
        }

        return list;
    }

    // Double.parseDouble(String s) : 将 s 转换成 double
    // Double.parseFloat(String s) : 将 s 转换成 float
    // Integer.parseInt(String s) : 将 s 转换成 int
    // Long.parseLong(String s) : 将 s 转换成 long

    public static String changeIn2String(int n) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add((char) (n % 10 + 0x30));
            if (n / 10 == 0)
                break;
            n = n / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

}
