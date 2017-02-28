public class AddStrings {

    public static void main(String[] args) {
        System.out.print(addStrings("0", "0"));
    }

    // public static String addStrings(String num1, String num2) {
    //
    // int length = Math.max(num1.length(), num2.length());
    // int[] c3 = new int[length+1];
    // int carry = 0;
    // for(int i = 0; i<=length; i++){
    // int n1 = i < num1.length()?num1.charAt(num1.length() - 1- i) - '0':0;
    // int n2 = i < num2.length()?num2.charAt(num2.length() - 1- i) - '0':0;
    // int sum = n1+n2+carry;
    // c3[i] = sum%10;
    // carry = sum/10;
    // }
    //
    // while(length >= 1 && c3[length] ==0){
    // length--;
    // }
    //
    // StringBuilder sb = new StringBuilder();
    // for(int i = length; i>=0; i--){
    // sb.append(c3[i]);
    // }
    // return sb.toString();
    // }

    public static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int n1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int n2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    // public static String addStrings(String num1, String num2) {
    // StringBuilder sb = new StringBuilder();
    // int carry = 0;
    // for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
    // int x = i < 0 ? 0 : num1.charAt(i) - '0';
    // int y = j < 0 ? 0 : num2.charAt(j) - '0';
    // sb.append((x + y + carry) % 10);
    // carry = (x + y + carry) / 10;
    // }
    // if (carry != 0)
    // sb.append(carry);
    // return sb.reverse().toString();
    // }

}
