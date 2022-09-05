import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例 1:
 * 
 *
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1,3,4]
 * 示例 2:
 * 
 * 输入:[1,null,3]
 * 输出:[1,3]
 * 示例 3:
 * 
 * 输入:[]
 * 输出:[]
 * 
 * 
 * 提示:
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100<= Node.val <= 100
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                recursion(list, root.left, 1);
            }
            if (root.right != null) {
                recursion(list, root.right, 1);
            }
        }
        return list;
    }

    public void recursion(List<Integer> list, TreeNode root, int index) {
        if (list.size() == index) {
            list.add(root.val);
        }
        list.set(index, root.val);
        ++index;
        if (root.left != null) {
            recursion(list, root.left, index);
        }
        if (root.right != null) {
            recursion(list, root.right, index);
        }
    }
}
