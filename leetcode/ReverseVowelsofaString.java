public class ReverseVowelsofaString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("olel"));
    }

    public static String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (start <= end) {
            while (!isVowel(s.charAt(start))) {
                start++;
                if (start >= s.length())
                    break;
            }
            while (!isVowel(s.charAt(end))) {
                end--;
                if (end < 0)
                    break;
            }
            if (start > end)
                break;
            else {
                sb.setCharAt(start, s.charAt(end));
                sb.setCharAt(end, s.charAt(start));
                start++;
                end--;
            }
        }
        return sb.toString();
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'
                || c == 'I' || c == 'O' || c == 'U';
    }

}
