import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "naaram"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), 1 + map.get(s.charAt(i)));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;

    }

}
