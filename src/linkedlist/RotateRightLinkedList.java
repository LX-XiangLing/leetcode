package linkedlist;

/**
 * @Author lixiang
 * @Date 2021/3/18
 */
public class RotateRightLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) {
            return head;
        }
        int length=1;
        ListNode tail=head;    //用来记录链表的末尾结点，后面有用
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }

        /*1.因为k值可能会大于链表的长度，那我们可以免去周期旋转的过程，也就是要对k值进行更新*/
        k = k % length;
        //如果更新后k值刚好为0，说明旋转次数刚好为周期的倍数，直接返回原链表即可
        if(k==0) {
            return head;
        }
        /*2.寻找找到旋转的切入点*/
        ListNode node=head;
        int step=length-k;
        while(step>1){
            node=node.next;
            step--;
        }

        ListNode newHead=node.next; //记录要返回的新头结点
        tail.next=head;
        node.next=null;

        return newHead;
    }
}
