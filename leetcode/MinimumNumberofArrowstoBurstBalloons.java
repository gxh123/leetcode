import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

    public static void main(String[] args) {
        int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() { // 先按起始位置排序
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });
        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) { // 一支箭的范围内
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
