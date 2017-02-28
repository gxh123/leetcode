public class PlusOne {

    public static void main(String[] args) {

    }

    // public static int[] plusOne(int[] digits) {
    // if(digits == null || digits.length == 0)
    // return new int[0];
    // int carry = 1;
    // int[] result = new int[digits.length + 1];
    // for(int i = digits.length - 1; i>=0; i--)
    // {
    // int sum = carry + digits[i];
    // result[i+1] = sum%10;
    // carry = sum/10;
    // }
    //
    // }
    // 很好的解法
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
