import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        generate3(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);
        if (numRows == 1)
            return result;
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        result.add(row2);
        if (numRows == 2)
            return result;

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> last = result.get(i - 1);
            for (int j = 1; j <= i - 1; j++) {
                row.add(last.get(j - 1) + last.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public static List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> last = result.get(i - 1);
                    row.add(last.get(j - 1) + last.get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

}
