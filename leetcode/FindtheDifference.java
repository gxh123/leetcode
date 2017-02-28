import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindtheDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)))
                map.put(t.charAt(i), 1);
            else
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException();
    }

    // interesting
    public char findTheDifference2(String s, String t) {
        // Initialize variables to store sum of ASCII codes for
        // each string
        int charCodeS = 0, charCodeT = 0;
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i)
            charCodeS += (int) s.charAt(i);
        for (int i = 0; i < t.length(); ++i)
            charCodeT += (int) t.charAt(i);
        // Return the difference between 2 strings as char
        return (char) (charCodeT - charCodeS);
    }

}
