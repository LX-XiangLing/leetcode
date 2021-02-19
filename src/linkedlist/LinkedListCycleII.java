package linkedlist;

import tree.TreeNode;

/**
 * @Author lixiang
 * @Date 2021/2/19
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }

        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
