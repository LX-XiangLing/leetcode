package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();   //  ArrayList为线性表
        // 将 链表的每一个节点依次 存进ArrayList中
        while(head != null){
            list.add(head);
            head = head.next;
        }
        // 两个指正依次从前 后进行遍历取元素
        int i = 0, j = list.size()-1;
        while(i < j){
            //  eg:  1->2->3->4
            // 前面的节点的下一个节点指向最后的节点
            list.get(i).next = list.get(j);  //  即 1->4
            i++;  // 此时 i++ 则此时 list.get(i) 为原来前面节点的下一个节点   即节点2
            if(i == j) // 若 链表长度为偶数的情况下 则会提前相遇，此时已达到题目要求，直接终止循环
            {
                break;
            }
            list.get(j).next = list.get(i);   // 4->2
            // 此时刚刚的例子则变为  1->4->2->3
            j--;
        }
        list.get(i).next = null;  // 最后一个节点的下一个节点为null
    }
}
