public class BullsandCows {

    public static void main(String[] args) {
        System.out.println(getHint("411231", "011114"));
    }

    // 讨论区有只用一个数组的，感觉不是很好理解
    public static String getHint(String secret, String guess) {
        int length = secret.length();
        int[] digits1 = new int[10]; // sercet
        int[] digits2 = new int[10]; // guess
        int bullsCount = 0;
        for (int i = 0; i < length; i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2)
                bullsCount++;
            else {
                digits1[secret.charAt(i) - '0']++;
                digits2[guess.charAt(i) - '0']++;
            }
        }
        int cowsCount = 0;
        for (int i = 0; i < 10; i++) {
            cowsCount += Math.min(digits1[i], digits2[i]);
        }
        return bullsCount + "A" + cowsCount + "B";
    }

}
