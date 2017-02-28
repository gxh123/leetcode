public class CountandSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(0));
    }

    public static String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char c = prev.charAt(0);
            int count = 0;
            for (int j = 0; j < prev.length(); j++) {
                if (c == prev.charAt(j)) {
                    count++;
                } else {
                    sb.append(count + "" + c);
                    c = prev.charAt(j);
                    count = 1;
                }
            }
            sb.append(count + "" + c); // 注意最后这一次不能忘了加
            prev = sb.toString();
        }
        return prev;
    }

}
