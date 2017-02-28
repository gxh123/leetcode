public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString(" Margelet's \"went.\" I await news telegram."));
    }

    // public static String reverseString(String s) {
    // List<Character> list = new ArrayList<>();
    // for (int i = 0; i < s.length(); i++) {
    // list.add(s.charAt(i));
    // }
    // StringBuilder sb = new StringBuilder();
    // for (int i = s.length() - 1; i >= 0; i--) {
    // sb.append(list.get(i));
    // }
    // return sb.toString();
    // }

    // public static String reverseString(String s) { // method 1
    // StringBuilder sb = new StringBuilder(s);
    // return sb.reverse().toString();
    // }

    public static String reverseString(String s) { // method 2 ,swap
        if (s == null || s.length() == 0)
            return "";

        char[] c = s.toCharArray();
        int start = 0, end = c.length - 1;
        while (start <= end) {
            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;
            start++;
            end--;
        }
        return new String(c);
    }
}
