import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= sLength - pLength; i++) {
            if (isAnagrams(s.substring(i, i + pLength), p)) {
                result.add(i);

            }
        }
        return result;
    }

    public static boolean isAnagrams(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

}
