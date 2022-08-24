/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MergeKLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode();
        if (lists.length == 0) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            if (root.next == null) {
                root.next = lists[i];
                continue;
            }
            ListNode node = lists[i];
            while (node != null) {
                addNode(root, node.val);
                node = node.next;
            }
        }
        return root.next;
    }

    /**
     *  3种情况讨论
     *  1. 要插入的结点是最大的 插到最后一个节点
     *  2. 要插入的结点比当前节点小 插到当前节点的上一个节点
     *  3. 要插入的结点比当前节点大及下一个节点小 插到当前节点的下一个节点
     * @param root
     * @param val
     */
    public void addNode(ListNode root, int val) {
        ListNode cur = root.next;
        ListNode pre = root;
        while (cur != null) {
            // 第一种情况
            if (cur.next == null && cur.val <= val) {
                cur.next = new ListNode(val);
                break;
            }
            // 第二种情况
            else if (cur.val > val) {
                ListNode newNext = new ListNode(val);
                pre.next = newNext;
                pre.next.next = cur;
                break;
            }
            // 第三种情况
            else if (cur.val <= val && cur.next.val > val) {
                ListNode node = cur.next;
                cur.next = new ListNode(val);
                cur.next.next = node;
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }
}
