public class LengthofLastWord {

    public static void main(String[] args) {
        System.out.print(lengthOfLastWord("Hello World World222 "));
    }

    public static int lengthOfLastWord2(String s) {
        if (s == null)
            return 0;
        int lengthOfWord = 0;
        String ss = s.trim();
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == ' ')
                lengthOfWord = 0;
            else
                lengthOfWord++;
        }
        return lengthOfWord;
    }

    // 从后往前，更快
    public static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        int lengthOfWord = 0;
        String ss = s.trim();
        for (int i = ss.length() - 1; i >= 0; i--) {
            if (ss.charAt(i) == ' ')
                return lengthOfWord;
            else
                lengthOfWord++;
        }
        return lengthOfWord;
    }

}
