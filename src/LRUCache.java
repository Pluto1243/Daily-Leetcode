import java.util.HashMap;

/**
 * LRU缓存
 * get 和 put  O(1)时间复杂度
 * https://leetcode.cn/problems/lru-cache/
 *
 * @author wangjie
 * @date 19:22 2023年09月19日
 **/
public class LRUCache {

    HashMap<Integer, ListNode> map = new HashMap<>();

    ListNode head = new ListNode();

    ListNode tail = new ListNode();

    int capacity;

    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);
            value = node.value;
        }
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode listNode = map.get(key);
            listNode.value = value;
            moveToHead(listNode);
        } else {
            ListNode newNode = new ListNode(key, value);
            addToHead(newNode);
            map.put(key, newNode);
            size++;
            if (size > capacity) {
                ListNode remove = removeTail();
                map.remove(remove.key);
                size--;
            }
        }
    }

    public void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(ListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public ListNode removeTail() {
        ListNode tail = this.tail.pre;
        removeNode(tail);
        return tail;
    }



    /**
     * Node双向链表
     *
     * @author wangjie
     * @date 09:11 2023年09月20日
     **/
    class ListNode {

        ListNode pre;

        ListNode next;

        int key;

        int value;

        public ListNode() {

        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */