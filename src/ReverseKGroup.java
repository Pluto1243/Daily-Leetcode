/**
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangjie
 * @date 10:20 2022年08月09日
 **/
public class ReverseKGroup {

    class ListNode {
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

//    public ListNode reverseKGroup(ListNode head, int k) {
//        // 取k之前的链表和k之后的链表
//        ListNode newHead;
//        ListNode nextHead = head.next;
//        while (k > 0) {
//            nextHead = nextHead.next;
//            k--;
//        }
//    }
}
