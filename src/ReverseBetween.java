/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ReverseBetween {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPre = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        // 防止空指针异常
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode node = newHead;
        if (left == 1) {
            leftPre = newHead;
            leftNode = newHead.next;
        }
        int index = 1;
        // 1 -> 2 -> 3
        while (node.next != null) {
            // 左值
            if (leftNode == null && node.next != null && left == index) {
                leftPre = node;
                leftNode = node.next;
            }
            // 右值
            if (rightNode == null && node.next != null && right == index) {
                rightNode = node.next;
            }
            if (leftNode != null && rightNode != null) {
                ListNode rightNext = rightNode.next;
                rightNode.next = null;
                ListNode reverse = reverse(leftNode);
                leftPre.next = reverse;
                leftNode.next = rightNext;
                break;
            }
            node = node.next;
            index++;
        }
        return newHead.next;
    }

    private static ListNode reverse(ListNode node) {
        ListNode newHead = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseBetween(head, 2, 2);
    }
}
