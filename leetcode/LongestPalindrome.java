import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out
                .print(longestPalindrome(new String(
                        "civilwartestingwhetherthatnaptionoranynartionsoconceive"
                                + "dandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportion"
                                + "ofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogether"
                                + "fangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallow"
                                + "thisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddor"
                                + "detractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhere"
                                + "Itisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsono"
                                + "blyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddead"
                                + "wetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyres"
                                + "olvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgo"
                                + "vernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1 + map.get(s.charAt(i)));
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int sum = 0;
        boolean hasOdd = false;
        Set<Character> keySet = map.keySet();
        for (char c : keySet) {
            int num = map.get(c);
            System.out.println("c:" + c + ",num:" + num);
            if (num % 2 == 0) {
                sum += num;
            } else {
                // 这里写错了，奇数的字符可以拿出偶数的部分来
                // if (num > maxOdd)
                // maxOdd = num;
                sum += num - 1;
                hasOdd = true;
            }
        }
        if (hasOdd == true)
            sum++;
        return sum;
    }

}
