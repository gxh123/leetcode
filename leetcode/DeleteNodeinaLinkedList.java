//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

public class DeleteNodeinaLinkedList {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        deleteNode(root.next.next);
        System.out.print("11");
    }

    public static void deleteNode(ListNode node) {
        if (node.next == null)
            node = null;

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
