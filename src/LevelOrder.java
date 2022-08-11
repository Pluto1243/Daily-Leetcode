import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        getLevelOrder(map, root, 0);
        if (root != null) {
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            list.add(arr);
        }
        for (int i = 0; i < map.size(); i++) {
            List<Integer> lists = map.get(i);
            list.add(lists);
        }
        return list;
    }

    public static void getLevelOrder(HashMap<Integer, List<Integer>> map, TreeNode node, Integer index) {
        // 如果左侧和右侧都没有值，结束递归
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        List<Integer> lists;
        if (map.containsKey(index)) {
            lists = map.get(index);
        } else {
            lists = new ArrayList<>();
        }
        // 添加值
        addNode(lists, node);
        // 左侧还有值，继续往下走
        if (node.left != null) {
            getLevelOrder(map, node.left, index + 1);
        }
        // 右侧还有值，继续往下走
        if (node.right != null) {
            getLevelOrder(map, node.right, index + 1);
        }
        map.put(index, lists);
    }

    public static void addNode(List<Integer> nodeList, TreeNode node) {
        if (node.left != null) {
            nodeList.add(node.left.val);
        }
        if (node.right != null) {
            nodeList.add(node.right.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        levelOrder(root);
    }
}
