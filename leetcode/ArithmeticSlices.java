public class ArithmeticSlices {

    public static void main(String[] args) {
        int[] A = { 1, 3, 5, 7, 9, 10, 11, 13, 15, 16, 17 };
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int difference = A[1] - A[0];
        int total = 0, tempCount = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == difference) {
                tempCount++;
            } else {
                if (tempCount >= 3)
                    total = total + (tempCount - 2) * (tempCount - 1) / 2;
                tempCount = 2;
                difference = A[i] - A[i - 1];
            }
        }
        if (tempCount >= 3)
            total = total + (tempCount - 2) * (tempCount - 1) / 2;
        return total;
    }

}
