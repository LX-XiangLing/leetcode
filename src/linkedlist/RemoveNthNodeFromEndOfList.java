package linkedlist;

/**
 * @Author lixiang
 * @Date 2021/2/18
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            end = end.next;
            n--;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return pre.next;
    }
}
