/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @author wangjie
 * @date 22:24 2023年09月29日
 **/
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(node, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        int length = getLength(head);
//        int targetIndex = length - n;
//        ListNode node = head;
//        ListNode pre = null;
//        for (int i = 0; i < targetIndex; i++) {
//            pre = node;
//            node = node.next;
//        }
//        if (targetIndex == 0) {
//            return head.next;
//        }
//        pre.next = node.next;
//        return head;
        ListNode node = new ListNode(0, head);
        ListNode first = node;
        ListNode second = node;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return node.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
