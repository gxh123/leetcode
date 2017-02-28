public class SingleNumberIII {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        singleNumber(nums);
    }

    // a^a = 0, a^0 = a
    // 异或有交换性
    // 异或可以将两个相同的数消掉
    // 这道题的思路:首先对所有的数进行异或，得到的结果是只出现一次的两个数的异或的结果
    // 然后对这个结果选取一个为1的一位，比如说第i位。根据第i位是否为1，将所有的数分为两组,
    // 则所有相同的数必将分在一组（相同的数第i位肯定相同），那两个出现一次的数必然分在两组（因为它们第i位不同）
    // 再对这两组数进行异或，就能分别求出那两个数了。
    public static int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) { // 对所有的数进行异或
            temp = temp ^ nums[i];
        }
        int differentBit = 0;
        while (temp != 0 && (temp & 1) == 0) { // 找到第一个非0的位（其实任意一个都可以）
            differentBit++;
            temp = temp >> 1;
        }
        int number1 = 0, number2 = 0;
        int mask = 1 << differentBit;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0)
                number1 = number1 ^ nums[i];
            else
                number2 = number2 ^ nums[i];
        }
        return new int[] { number1, number2 };
    }
}
