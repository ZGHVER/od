package LeetCode;


@SuppressWarnings("unused")
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode CrateList(int... a) {
        ListNode he = new ListNode(1);
        ListNode node = he;
        for (int i : a) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return he.next;
    }

    public static void printList(ListNode lt) {
        if (lt == null) System.out.println("[]");
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ListNode tem = lt;
        while (tem != null) {
            sb.append(tem.val).append(",");
            tem = tem.next;
        }
        int t = sb.lastIndexOf(",");
        sb.delete(t,t+1);
        sb.append(" ]");
        System.out.println(sb);
    }
}
