import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsSubsequence {

    public static void main(String[] args) {
        // System.out.println(isSubsequence2("abcb", "bahbgdca"));
        demo();
    }

    public static boolean isSubsequence(String s, String t) { // s是不是t的子序列
        if (s.length() > t.length())
            return false;

        int index1 = 0, index2 = 0;
        while (index2 < t.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
                if (index1 == s.length())
                    return true;
            }
            index2++;
        }
        return false;
    }

    // Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
    // Eg-1. s="abc", t="bahbgdca"
    // idx=[a={1,7}, b={0,3}, c={6}]
    // i=0 ('a'): prev=1
    // i=1 ('b'): prev=3
    // i=2 ('c'): prev=6 (return true)
    // Eg-2. s="abc", t="bahgdcb"
    // idx=[a={1}, b={0,6}, c={5}]
    // i=0 ('a'): prev=1
    // i=1 ('b'): prev=6
    // i=2 ('c'): prev=? (return false)
    // 挺难的，不是很好想通
    public static boolean isSubsequence2(String s, String t) {
        List<Integer>[] list = new ArrayList[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (list[t.charAt(i)] == null)
                list[t.charAt(i)] = new ArrayList<>();
            list[t.charAt(i)].add(i); // 将t里面的每个字符出现的位置都记录下来
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list[s.charAt(i)] == null)
                return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(list[s.charAt(i)], prev); // 这里因为是按顺序添加的，已经保证了每个list里面都是升序的！！
            if (j < 0)
                j = -j - 1;
            if (j == list[s.charAt(i)].size())
                return false;
            prev = list[s.charAt(i)].get(j) + 1; // 下一个字符在这个字符后面至少加1的位置
        }
        return true;
    }

    // 使用Collections.binarySearch的例子
    public static void demo() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(20);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(4);
        Collections.sort(list);
        // search the list for key 'QUALITY'
        int index = Collections.binarySearch(list, 6); // 返回的是排序以后的顺序的索引值！！
        // System.out.println("'QUALITY' is available at index: " + index);

        ArrayList<Integer> list2 = new ArrayList<Integer>(); // 下面为了测试就直接添加一个升序的
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(9);

        // 找不到的话返回的是-insertionPoint-1
        // 比如说0,0应该放在list2的0这个位置，所以返回的是-0-1 = -1
        // 比如说2,2应该放在list2的1这个位置，所以返回的是-1-1 = -2
        int index2 = Collections.binarySearch(list2, 0);
        System.out.println("'QUALITY' is available at index: " + index2);
        index2 = Collections.binarySearch(list2, 2);
        System.out.println("'QUALITY' is available at index: " + index2);
    }
}
