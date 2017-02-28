public class CompareVersionNumbers {

    public static void main(String[] args) {
        int a = Integer.parseInt("01");
        System.out.println(a);
        System.out.println(compareVersion("02.0", "02"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."); // 点是特殊字符，要转义
        String[] v2 = version2.split("\\.");
        int num1 = Integer.parseInt(v1[0]);
        int num2 = Integer.parseInt(v2[0]);
        if (num1 > num2)
            return 1;
        else if (num1 < num2)
            return -1;
        else {
            if (v1.length == 1 && v2.length == 1 || v1.length == 1 && Integer.parseInt(v2[1]) == 0
                    || v2.length == 1 && Integer.parseInt(v1[1]) == 0)
                return 0;
            if (v2.length == 1)
                return 1;
            if (v1.length == 1)
                return -1;

            num1 = Integer.parseInt(v1[1]);
            num2 = Integer.parseInt(v2[1]);
            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
            else
                return 0;
        }
    }

}
