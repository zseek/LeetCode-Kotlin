package easy

/**
 * 二叉树的中序遍历(栈,树,深度优先搜索,二叉树)
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树的根节点 root, 返回它的中序遍历
 * 输入: [1,null,2,3]
 * 输出: [1,3,2]
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = mutableListOf<TreeNode>()
    var current = root

    while (current != null || stack.isNotEmpty()) {
        while (current != null) { // 沿左子树入栈
            stack.add(current)
            current = current.left
        }
        current = stack.removeAt(stack.size - 1) // 弹出栈顶节点
        result.add(current.`val`) // 访问该节点
        current = current.right // 转向右子树
    }

    return result
}
