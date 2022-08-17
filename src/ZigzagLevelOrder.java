import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 * 
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @author wangjie
 * @date 15:15 2022年08月17日
 **/
public class ZigzagLevelOrder {

    public class TreeNode {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(root, 0, list);
        return list;
    }

    public void recursion(TreeNode node, Integer level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        // 新建下一层
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        // 遍历到第几层 操作第几层
        List<Integer> nodeList = list.get(level);
        // 从左到右
        if (level % 2 == 0) {
            nodeList.add(node.val);
        } else {
            nodeList.add(0, node.val);
        }
        recursion(node.left, level + 1, list);
        recursion(node.right, level + 1, list);
    }
}
