public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }

    public static int firstBadVersion(int n) {
        // if (isBadVersion(1))
        // return 1;
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    static boolean isBadVersion(int version) {
        if (version >= 1)
            return true;
        else
            return false;
    }

}
