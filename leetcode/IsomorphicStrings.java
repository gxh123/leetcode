import java.util.Arrays;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] c1 = new int[256];
        int[] c2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            c1[s.charAt(i)]++;
            c2[t.charAt(i)]++;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < 256; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }

}
