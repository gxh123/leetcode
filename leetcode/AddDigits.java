public class AddDigits {

    public static void main(String[] args) {

        System.out.print(addDigits(9));
    }

    public static int addDigits(int num) {
        if (num == 0)
            return 0;
        if (num % 9 == 0)
            return 9;
        else
            return num % 9;
    }

}
