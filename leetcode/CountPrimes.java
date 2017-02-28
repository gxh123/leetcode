public class CountPrimes {

    public static void main(String[] args) {
        System.out.print(countPrimes(5));
    }

    // 除了1和它本身以外不再有其他因数的数称为质数,0不是质数
    // 一个数是质数，它的倍数都不是
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] isPrime = new boolean[n];
        isPrime[2] = true;
        for (int i = 3; i < n; i = i + 2) { // 初始所有的奇数质数，偶数为素数
            isPrime[i] = true;
        }
        for (int i = 3; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < n; j = j + i)
                    isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
