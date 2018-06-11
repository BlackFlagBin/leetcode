package problem203;

/**
 * 203. 删除链表中的节点
 *
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode cur=dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next=cur.next.next;
            } else {
                cur=cur.next;
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}