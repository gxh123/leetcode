import java.util.HashMap;
import java.util.Map;

public class TwoSumII_Inputarrayissorted {

    public static void main(String[] args) {
        int a = 2;
        System.out.println(a / 3);
    }

    // 就用hashmap或者两个指针来做，O(n)
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ret[0] = map.get(target - numbers[i]) + 1;
                ret[1] = i + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        return ret;
    }

    // two-pointer method
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] ret = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target)
                r--;
            else if (sum < target)
                l++;
            else {
                ret[0] = l + 1;
                ret[1] = r + 1;
                break;
            }
        }
        return ret;
    }

}
