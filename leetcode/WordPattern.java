import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "aaaa";
        String str = "dog cat cat dog";
        System.out.print(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>(); // pattern 到str的映射
        Map<String, Character> map2 = new HashMap<>(); // str 到pattern的映射
        String[] strs = str.trim().split(" ");
        if (pattern.length() != strs.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.containsKey(pattern.charAt(i))) {
                map1.put(pattern.charAt(i), strs[i]);
            } else {
                // 要用equals比较字符串，用==比较的是地址是否一样
                // if (map.get(pattern.charAt(i)) != (strs[i]))
                // return false;
                if (!map1.get(pattern.charAt(i)).equals(strs[i]))
                    return false;
            }
            if (!map2.containsKey(strs[i])) {
                map2.put(strs[i], pattern.charAt(i));
            } else {
                if (map2.get(strs[i]) != (pattern.charAt(i)))
                    return false;
            }
        }
        return true;
    }
}
