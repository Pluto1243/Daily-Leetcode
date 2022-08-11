/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MergeTwoLists {

    static class ListNode {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (list1 == null && list2 == null) {
//            return null;
//        }
//        ListNode next = new ListNode();
//        ListNode newList = new ListNode();
//        newList.next = next;
//        while (list1 != null || list2 != null) {
//            if (list1 == null) {
//                list2 = addNode(next, list2);
//                next = next.next;
//                continue;
//            } else if (list2 == null) {
//                list1 = addNode(next, list1);
//                next = next.next;
//                continue;
//            }
//            int val1 = list1.val;
//            int val2 = list2.val;
//            if (val1 > val2) {
//                // 添加2的节点
//                list2 = addNode(next, list2);
//            } else {
//                // 添加1的节点
//                list1 = addNode(next, list1);
//            }
//            next = next.next;
//        }
//        return newList.next.next;
       if (l1 == null) {
           return l2;
       }
       if (l2 == null) {
           return l1;
       }
       if (l1.val > l2.val) {
           l2.next = mergeTwoLists(l1, l2.next);
           return l2;
       } else {
           l1.next = mergeTwoLists(l1.next, l2);
           return l1;
       }
    }

    public static ListNode addNode(ListNode next, ListNode list) {
        next.next = new ListNode(list.val);
        if (list.next != null) {
            return list.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(-9);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);
        ListNode list = mergeTwoLists(list1, list2);
        System.out.println(list);
    }
}
