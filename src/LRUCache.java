import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存
 * get 和 put  O(1)时间复杂度
 * https://leetcode.cn/problems/lru-cache/
 *
 * @author wangjie
 * @date 19:22 2023年09月19日
 **/
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */