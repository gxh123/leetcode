public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++)
            System.out.println(convertToTitle(i));
    }

    // 绕的不行
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append((char) (n % 26 + 'A' - 1));
                n = n / 26;
            }
        }
        return sb.reverse().toString();
    }

}
