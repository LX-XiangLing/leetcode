package linkedlist;

/**
 * @Author lixiang
 * @Date 2021/2/19
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        ListNode last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }
}
