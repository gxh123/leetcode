public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() == 0 || s.trim().length() == 0)
            return true;

        String ss = s.trim();
        int left = 0, right = ss.length() - 1;
        while (left < right) {
            while (left < right && !isAlphanumeric(ss.charAt(left)))
                // 这种增加一定要考虑范围
                left++;
            while (left < right && !isAlphanumeric(ss.charAt(right)))
                right--;
            if (left >= right) // 忽略了
                return true;
            if (!isEqual(ss.charAt(left), ss.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(char c) {
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    public static boolean isEqual(char l, char r) {
        if (l == r || Math.abs(l - r) == ('a' - 'A') && (l >= 'A') && (r >= 'A'))
            return true;
        return false;
    }

}
