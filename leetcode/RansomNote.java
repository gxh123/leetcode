import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "abb"));
    }

    // public static boolean canConstruct(String ransomNote, String magazine) {
    // if (ransomNote == null || ransomNote.length() == 0)
    // return true;
    // if (magazine == null || magazine.length() == 0)
    // return false;
    //
    // for (int i = 0; i < magazine.length(); i++) {
    // int j = 0;
    // for (j = 0; j < ransomNote.length(); j++) {
    // if (i + j >= magazine.length())
    // return false;
    // if (magazine.charAt(i + j) != ransomNote.charAt(j))
    // break;
    // }
    // if (j == ransomNote.length())
    // return true;
    //
    // }
    // return false;
    // }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0)
            return true;
        if (magazine == null || magazine.length() == 0)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!map.containsKey(magazine.charAt(i)))
                map.put(magazine.charAt(i), 1);
            else
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            int count = map.get(ransomNote.charAt(i));
            count--;
            if (count == -1)
                return false;
            map.put(ransomNote.charAt(i), count);
        }
        return true;

    }

}
