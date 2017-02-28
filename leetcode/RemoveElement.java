public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 3, 3, 3, 2, 3, 3, 3 };
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        return index;
    }

    public static int removeElement1(int[] nums, int val) {
        int valPoint = 0, otherPoint = 0;
        while (valPoint < nums.length && otherPoint < nums.length) {
            while (nums[valPoint] != val) {
                valPoint++;
                if (valPoint >= nums.length) {
                    break;
                }
            }
            while (nums[otherPoint] == val) {
                otherPoint++;
                if (otherPoint >= nums.length) {
                    break;
                }
            }
            if (valPoint >= nums.length || otherPoint >= nums.length)
                break;
            else {
                if (valPoint < otherPoint) { // 交换 ,将非目标的数往前调到目标数的位置
                    int temp = nums[valPoint];
                    nums[valPoint] = nums[otherPoint];
                    nums[otherPoint] = temp;
                    valPoint++;
                    otherPoint++;
                } else { // 非目标的数已经在前面的不用调
                    otherPoint++;
                }
            }
        }
        return valPoint;
    }

}
