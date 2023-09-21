import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表。
 * TODO 双指针解法
 *
 * @author wangjie
 * @date 18:36 2023年09月21日
 **/
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Boolean> nodes = new TreeMap<>();
        while(head != null) {
            if (nodes.containsKey(head.val)) {
                nodes.put(head.val, false);
            } else {
                nodes.put(head.val, true);
            }
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode next = null;
        for (Map.Entry<Integer, Boolean> entry : nodes.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            if (next == null && value) {
                next = new ListNode(key);
                result.next = next;
            } else if (value) {
                next.next = new ListNode(key);
                next = next.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);

        System.out.println(deleteDuplicates(listNode));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
