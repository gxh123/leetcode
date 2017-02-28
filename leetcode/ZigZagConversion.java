import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 2));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            int offset = i % (2 * numRows - 2);
            if (offset < numRows) {
                list.get(offset).append(s.charAt(i));
            } else {
                list.get(2 * numRows - 2 - offset).append(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
