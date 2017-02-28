public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 1;
        int lengthB = 1;

        ListNode iterA = headA;
        while (iterA.next != null) {
            iterA = iterA.next;
            lengthA++;
        }

        ListNode iterB = headB;
        while (iterB.next != null) {
            iterB = iterB.next;
            lengthB++;
        }

        if (iterA != iterB) { // 如果最后一个不相同，表示没有交集
            return null;
        }

        if (lengthA > lengthB) {
            int tmp = lengthA - lengthB;
            while (tmp > 0) {
                headA = headA.next;
                tmp--;
            }
        } else {
            int tmp = lengthB - lengthA;
            while (tmp > 0) {
                headB = headB.next;
                tmp--;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

}
