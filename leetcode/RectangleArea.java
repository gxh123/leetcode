public class RectangleArea {

    public static void main(String[] args) {

    }

    // 想不到，不是自己写的
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        // If overlap
        int overlap = 0;
        if (right > left && top > bottom)
            overlap = (right - left) * (top - bottom);

        return area1 + area2 - overlap;
    }

}
